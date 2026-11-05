package com.example.demo;

import java.util.List;

public class Catalogue {

    private final List<Book> books;

    public Catalogue(BookSource source) {
        this.books = source.load();
    }

    public List<String> titlesBy(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .map(Book::getTitle)
                .sorted()
                .toList();
    }
}
