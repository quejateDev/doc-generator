package com.quejate.documentgenerator.services;

import com.quejate.documentgenerator.dtos.TutelaRequestDTO;
import com.quejate.documentgenerator.prompts.TutelaPromptGenerator;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class TutelaGeneratorService {
    private final ChatClient chatClient;
    private final TutelaPromptGenerator promptGenerator;

    public TutelaGeneratorService(ChatClient.Builder chatClient, TutelaPromptGenerator promptGenerator) {
        this.chatClient = chatClient.build();
        this.promptGenerator = promptGenerator;
    }

    public String generarTutela(TutelaRequestDTO request) {
        String prompt = promptGenerator.generatePrompt(request);
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
