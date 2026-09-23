package com.example.demo;

import java.util.List;

public class InMemoryBookSource implements BookSource {

    @Override
    public List<Book> load() {
        return List.of(
                new Book("1984", "George Orwell"),
                new Book("Brave New World", "Aldous Huxley"),
                new Book("Fahrenheit 451", "Ray Bradbury")
        );
    }
}