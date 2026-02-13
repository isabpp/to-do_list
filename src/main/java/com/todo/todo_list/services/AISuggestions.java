package com.todo.todo_list.services;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class AISuggestions {
    private final Client client;

    public AISuggestions(Client client) {
        String apiKey = System.getenv("GEM_API_KEY");
        this.client = Client.builder().apiKey(apiKey).build();
    }
}
