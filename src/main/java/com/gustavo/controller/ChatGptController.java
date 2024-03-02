package com.gustavo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.service.ChatGptService;
import com.gustavo.vo.response.ChatGptResponse;

@RestController
@RequestMapping("/bot")
public class ChatGptController {
	
	@Autowired
	private ChatGptService service;
	
	@GetMapping("/chat")
	public ChatGptResponse chat(@RequestParam("prompt") String prompt) {
		return service.chat(prompt);
	}

}
