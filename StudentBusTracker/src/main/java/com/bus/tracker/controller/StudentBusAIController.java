package com.bus.tracker.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bus.tracker.aitool.BusMovementAITool;
import com.bus.tracker.aitool.ParentAITool;
import com.bus.tracker.aitool.StudentAITool;
import com.bus.tracker.context.ParentContext;

@RestController
@RequestMapping("/studentbustracker/ai")
public class StudentBusAIController {

	
  @Autowired
  ChatClient ollamaChatClient;
	
	
	@Autowired
	BusMovementAITool busMovementTool;
	
	@Autowired
	StudentAITool studentAITool;
	
	@Autowired
	ParentAITool parentAITool;
	
	@Autowired
	ParentContext parentContext;



    @GetMapping("/ask")
    public String ask(@RequestParam String question) {


    	int parentId = parentContext.getCurrentParentId();


        String conversationId = "parent-" + parentId;
    	
    	 return ollamaChatClient
                 .prompt()
                 .user(question)
                 .tools(busMovementTool,studentAITool,parentAITool)
                 .advisors(a -> a.param(
                         ChatMemory.CONVERSATION_ID,
                         conversationId
                 )
                 .param(
                         "parentId",
                         String.valueOf(parentId)
                     )
                 )
                 .call()
                 .content();
    }
}
