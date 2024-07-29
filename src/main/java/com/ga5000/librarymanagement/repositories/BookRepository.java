package com.ga5000.librarymanagement.repositories;

import com.ga5000.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query("SELECT b FROM Book b WHERE b.yearOfPublication = :year")
    List<Book> findBooksByYear(int year);

    @Query("SELECT b FROM Book b WHERE b.author = :author")
    List<Book> findBooksByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    List<Book> findBooksByTitle(String title);
}
