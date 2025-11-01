package com.langchain_mysql.promptMysql.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.SystemMessage;

@Component
public class StockTool {
	
	
	
	@Autowired
	private JdbcTemplate template;
	
	
	@Tool("Execute read-only SQL queries (SELECT only) on the product database and return results in JSON.")
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
			return "Error executing query: " + e.getMessage();
		}
		
	}

}
