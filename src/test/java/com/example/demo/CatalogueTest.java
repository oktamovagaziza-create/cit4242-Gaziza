package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatalogueTest {

    @Test
    void inMemorySourceReturnsThreeBooks() {
        BookSource source = new InMemoryBookSource();

        List<Book> books = source.load();

        assertEquals(3, books.size());
        assertEquals("1984", books.get(0).getTitle());
        assertEquals("George Orwell", books.get(0).getAuthor());
    }

    @Test
    void csvSourceReturnsThreeBooks() {
        BookSource source = new CsvBookSource("books.csv");

        List<Book> books = source.load();

        assertEquals(3, books.size());
        assertEquals("1984", books.get(0).getTitle());
        assertEquals("George Orwell", books.get(0).getAuthor());
    }
}