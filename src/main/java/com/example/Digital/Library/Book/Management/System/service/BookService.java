package com.example.Digital.Library.Book.Management.System.service;

import com.example.Digital.Library.Book.Management.System.model.Book;
import com.example.Digital.Library.Book.Management.System.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ApplicationContext context;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(String bookId) {
        return bookRepository.findByBookId(bookId);
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> updateBook(String bookId, Book updatedBook) {
        return bookRepository.findByBookId(bookId).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setAvailabilityStatus(updatedBook.getAvailabilityStatus()); // Fixed setter name
            return bookRepository.save(book);
        });
    }

    public boolean deleteBook(String bookId) {
        return bookRepository.findByBookId(bookId).map(book -> {
            bookRepository.delete(book);
            return true;
        }).orElse(false);
    }

    // ✅ **Updated Exit System Function**
    public String exitSystem() {
        String message = "Shutting down Library Management System...";
        System.out.println("\n" + message);

        // Delay shutdown to allow API response to be sent
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Wait 1 second before shutting down
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            SpringApplication.exit(context, () -> 0);
        }).start();

        return message; // Ensure response is sent before shutdown
    }
}
