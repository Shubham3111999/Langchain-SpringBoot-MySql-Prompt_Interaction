package com.langchain_mysql.promptMysql.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langchain_mysql.promptMysql.repository.ProductRepo;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.SystemMessage;

@Component
public class StockTool {
	
	@Autowired
	private ProductRepo repo;
	
	
	@Autowired
	private JdbcTemplate template;
	
	
	@Tool("Execute read-only SQL queries (SELECT only) on the product database and return "
			+ "results in JSON.")
	public String executeQuery(String Sql) {
		
		if(!Sql.trim().toLowerCase().startsWith("select")) {
			return "Error: Only SELECT queries are allowed.";
		}
		
		try {
			var result = template.queryForList(Sql);
			
			if(result.isEmpty()) {
				return "No results found.";
			}
			
			return new ObjectMapper().writeValueAsString(result);
		}catch(Exception e) {
			return "Error: executing query: " + e.getMessage();
		}
		
	}
	
	

	
//	@Tool("Get stock quantity for a specific product")
//	public String getStock(String productName) {
//		return repo.findByName(productName).map( p -> "There are " + 
//				p.getStock() + " units of " + p.getName() + " left in stock.")
//                .orElse("No product found with name " + productName);
//	}
//	
//	
//	@Tool("List all products that have stock less than given threshold")
//	public String listLowStock(int threshold) {
//        
//		 var low = repo.findByStockLessThan(threshold);
//	     if (low.isEmpty()) return "All products are well stocked.";
//	     
//	     return low.stream()
//                 .map(p -> p.getName() + " (" + p.getStock() + ")")
//                 .reduce((a,b) -> a + ", " + b)
//                 .orElse("");
//    }
}
