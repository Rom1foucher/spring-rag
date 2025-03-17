package com.rom1.spring_rag.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AssistantAIService {
    @SystemMessage(fromResource = "/prompts/system.st")
    public String chat(String userMessage);
}
