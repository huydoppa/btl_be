package com.example.demo.payload;

import com.example.demo.dtos.BookDTO;

import java.util.List;

public class BookResponse {
    public BookResponse(List<BookDTO> books) {
        this.books = books;
    }

    public BookResponse(BookDTO book) {
        this.book = book;
    }

    private List<BookDTO> books;

    private BookDTO book;

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }
}
