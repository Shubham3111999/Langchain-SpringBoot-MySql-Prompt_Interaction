package com.langchain_mysql.promptMysql.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface Assistant {
	@SystemMessage("""
			You are a data analyst assistant with access to a MySQL database.
			The database contains a 'products' table with columns:
	        id (BIGINT), name (VARCHAR), category (VARCHAR), stock (INT), price (FLOAT).
	        When the user asks for data, generate the most appropriate SQL SELECT query and execute it.
	        Respond with clear explanations based on query results.
				""")
	String chat(@MemoryId String email , @UserMessage String userQuestion);      //Langchain will complete for us
	
}
