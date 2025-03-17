package com.rom1.spring_rag.web.rest;

import com.rom1.spring_rag.service.AssistantAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantResource {
    private final AssistantAIService assistantService;

    AssistantResource(AssistantAIService assistantService) {
        this.assistantService = assistantService;
    }

    @PostMapping("/assistants/chat")
    public String chat(@RequestBody String query) {
        return assistantService.chat(query);
    }
}
