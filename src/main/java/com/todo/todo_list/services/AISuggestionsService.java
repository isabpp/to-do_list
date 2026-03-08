package com.todo.todo_list.services;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.todo.todo_list.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class AISuggestionsService {
    private final Client client;

    public AISuggestionsService() {
        String apiKey = System.getenv("GEMINI_API_KEY");
        this.client = Client.builder().apiKey(apiKey).build();
    }

    public String generateSuggestion(String task) {
        GenerateContentResponse response = client.models.generateContent(
                "gemini-3-flash-preview",
                "Provide a suggestion for: " + task,
                null
        );
        return response.text();
    }
}
