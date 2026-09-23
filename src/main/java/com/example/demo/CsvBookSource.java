package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvBookSource implements BookSource {

    private final String resource;

    public CsvBookSource(String resource) {
        this.resource = resource;
    }

    @Override
    public List<Book> load() {
        List<Book> books = new ArrayList<>();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resource);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",", 2);
                books.add(new Book(parts[0].trim(), parts[1].trim()));
            }

        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Failed to load " + resource, e);
        }

        return books;
    }
}