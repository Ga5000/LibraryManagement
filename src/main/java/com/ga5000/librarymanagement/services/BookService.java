package com.ga5000.librarymanagement.services;

import com.ga5000.librarymanagement.model.Book;
import com.ga5000.librarymanagement.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        Sort sort = Sort.by("author").ascending()
                .and(Sort.by("yearOfPublication").ascending());

        return bookRepository.findAll(sort);
    }

    @Transactional
    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }

    public List<Book> getBooksByYear(int year){
        return bookRepository.findBooksByYear(year);
    }


    public List<Book> getBooksByAuthor(String author){
        return bookRepository.findBooksByAuthor(author);
    }

    public List<Book> getBookByTitle(String title){
        return bookRepository.findBooksByTitle(title);
    }

    public Optional<Book> checkIfBookExists(UUID id){
        return bookRepository.findById(id);
    }

    public Book findBookByISBN(String isbn){
        return bookRepository.findByISBN(isbn);
    }



}
