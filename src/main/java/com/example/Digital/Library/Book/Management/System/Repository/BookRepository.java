package com.example.Digital.Library.Book.Management.System.Repository;

import com.example.Digital.Library.Book.Management.System.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookId(String bookId);
    Optional<Book> findByTitle(String title);
}
