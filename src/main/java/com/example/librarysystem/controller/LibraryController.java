package com.example.librarysystem.controller;

import com.example.librarysystem.model.Book;
import com.example.librarysystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library") // This means all URLs start with /api/library
@CrossOrigin // Allows frontend apps to talk to this later
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    // 1. Get all books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.findAllBooks();
    }

    // 2. Add a new book
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    // 3. Borrow a book
    @PostMapping("/borrow/{id}")
    public Book borrowBook(@PathVariable Long id) {
        return libraryService.borrowBook(id);
    }
}