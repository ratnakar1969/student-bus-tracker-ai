package com.bus.tracker.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentBusTrackerAIConfig {
	  @Bean
	    public ChatClient chatClient(OllamaChatModel ollamaChatModel) {
	        return ChatClient.builder(ollamaChatModel).build();
	    }

}
