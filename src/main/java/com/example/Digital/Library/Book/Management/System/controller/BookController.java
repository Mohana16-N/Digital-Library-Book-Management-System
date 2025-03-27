package com.example.Digital.Library.Book.Management.System.controller;

import com.example.Digital.Library.Book.Management.System.model.Book;
import com.example.Digital.Library.Book.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable String bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Optional<Book>> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.getBookByTitle(title));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Optional<Book>> updateBook(@PathVariable String bookId, @RequestBody Book updatedBook) {
        return ResponseEntity.ok(bookService.updateBook(bookId, updatedBook));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable String bookId) {
        return ResponseEntity.ok(bookService.deleteBook(bookId));
    }

    // ✅ **Updated Exit System API**
    @PostMapping("/exit")
    public ResponseEntity<String> exitSystem() {
        String message = bookService.exitSystem();
        return ResponseEntity.ok(message); // Return message before shutdown
    }
}
