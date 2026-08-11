package com.bus.tracker.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bus.tracker.aitool.BusMovementAITool;
import com.bus.tracker.aitool.StudentAITool;

@RestController
@RequestMapping("/studentbustracker/ai")
public class StudentBusAIController {

	
  @Autowired
  ChatClient ollamaChatClient;
	
	
	@Autowired
	BusMovementAITool busMovementTool;
	
	@Autowired
	StudentAITool studentAITool;
	



    @GetMapping("/ask")
    public String ask(@RequestParam String question) {

    	 return ollamaChatClient
                 .prompt()
                 .user(question)
                 .tools(busMovementTool,studentAITool)
                 .call()
                 .content();
    }
}
