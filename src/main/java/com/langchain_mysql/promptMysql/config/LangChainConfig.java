package com.langchain_mysql.promptMysql.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.langchain_mysql.promptMysql.assistant.Assistant;
import com.langchain_mysql.promptMysql.tools.StockTool;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class LangChainConfig {
	
	@Value("${gemenia-api.key}")
	private String apiKey;
	
	@Bean
    public ChatModel chatModel() {
        return GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .build();
    }
	
	
	@Bean
	public Assistant assistant(StockTool tools , ChatModel model) {
		return AiServices.builder(Assistant.class)
				.chatModel(model)
				.tools(tools)
				.build();
	}
	
}
