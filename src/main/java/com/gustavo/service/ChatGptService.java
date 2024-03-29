package com.gustavo.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gustavo.vo.request.ChatGptRequest;
import com.gustavo.vo.response.ChatGptResponse;

@Service
public class ChatGptService {
	
	private Logger logger = Logger.getLogger(ChatGptService.class.getName());
	
	@Value("${openai.model}")
	private String model;
	
	@Value("${openai.api.url}")
	private String url;
	
	@Autowired
	private RestTemplate template;

	public String chat(String prompt) {
		
		logger.info("Starting prompt");
		
		ChatGptRequest request = new ChatGptRequest(model, prompt);
	
		logger.info("Processing Prompt");
		
		ChatGptResponse response = template.postForObject(url, request, ChatGptResponse.class);
	
		return response.getChoices().get(0).getMessage().getContent();
	}
}
