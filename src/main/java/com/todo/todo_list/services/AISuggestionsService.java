package com.todo.todo_list.services;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class AISuggestionsService {
    private final Client client;

    public AISuggestionsService(Client client) {
        String apiKey = System.getenv("GEM_API_KEY");
        this.client = Client.builder().apiKey(apiKey).build();
    }
}
