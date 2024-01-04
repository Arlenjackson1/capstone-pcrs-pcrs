package com.pcrs.pcrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pcrs.pcrs.dto.ChatRequest;
import com.pcrs.pcrs.dto.ChatResponse;

@RestController
@RequestMapping("/bot")
@CrossOrigin(origins = "localhost:3000")
public class BotController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {
        try {
            String conditionatedPrompt = "" + prompt;
            ChatRequest request = new ChatRequest(model, conditionatedPrompt);

            ChatResponse chatResponse = 
            restTemplate.postForObject(apiURL, request, ChatResponse.class);

            return chatResponse
            .getChoices()
            .get(0)
            .getMessage()
            .getContent();
        } catch (Exception e) {
            return "Error processing the chat request. " + e;
        }
    }

}
