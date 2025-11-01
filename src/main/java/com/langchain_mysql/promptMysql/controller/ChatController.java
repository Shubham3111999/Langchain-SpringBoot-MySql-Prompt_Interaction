package com.langchain_mysql.promptMysql.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.langchain_mysql.promptMysql.assistant.Assistant;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private Assistant assistant;
	
	@PostMapping
	public String chat(@RequestBody Map<String, String> req) {
		return assistant.chat( req.get("question") );
	}
}
