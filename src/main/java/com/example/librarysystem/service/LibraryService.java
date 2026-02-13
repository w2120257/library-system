package com.example.librarysystem.service;

import com.example.librarysystem.model.Book;
import com.example.librarysystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book borrowBook(Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.getAvailableCopies() > 0) {
                book.setAvailableCopies(book.getAvailableCopies() - 1);
                return bookRepository.save(book);
            } else {
                throw new RuntimeException("No copies available");
            }
        } else {
            throw new RuntimeException("Book not found");
        }
    }
}