package com.langchain_mysql.promptMysql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.langchain_mysql.promptMysql.entity.Products;

public interface ProductRepo extends JpaRepository<Products, Long>{
	
	Optional<Products> findByName(String productName);

	List<Products> findByStockLessThan(int threshold);

}
