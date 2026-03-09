package com.yczuoxin.demo.springaidemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ChatController {

    private final ChatModel ollamaChatModel;

    public ChatController(ChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @PostMapping("/ai/chat")
    public String chat(@RequestParam(defaultValue = "Give me a short tech joke.") String prompt) {
        log.info("call ai ...");
        ChatResponse response = ollamaChatModel.call(new Prompt(prompt));
        log.info("call ai end");
        String content = response.getResult().getOutput().getText();
        return content;
    }
}
