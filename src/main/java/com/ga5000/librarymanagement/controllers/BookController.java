package com.ga5000.librarymanagement.controllers;

import com.ga5000.librarymanagement.dtos.BookRequestDTO;
import com.ga5000.librarymanagement.dtos.BookUpdateRequestDTO;
import com.ga5000.librarymanagement.exceptions.InvalidBookDataException;
import com.ga5000.librarymanagement.model.Book;
import com.ga5000.librarymanagement.services.BookService;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addBook(@RequestBody @Valid BookRequestDTO bookRequestDTO) throws InvalidBookDataException {
        var book = new Book();
        BeanUtils.copyProperties(bookRequestDTO,book);
        bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> displayAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping("/books-by-year")
    public ResponseEntity<List<Book>> searchBooksByYear(@RequestBody @Valid int year){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByYear(year));
    }

    @GetMapping("books-by-title")
    public ResponseEntity<List<Book>> searchBooksByTitle(@RequestBody @Valid String title){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookByTitle(title));
    }

    @GetMapping("books-by-author")
    public ResponseEntity<List<Book>> searchBooksByAuthor(@RequestBody @Valid String author){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByAuthor(author));
    }

    @PutMapping("/edit/{bookId}")
    public ResponseEntity<Object> updateBook(@PathVariable("id") @Valid UUID bookId, @RequestBody @Valid BookUpdateRequestDTO bookUpdateRequestDTO){
        Optional<Book> bookToUpdate = bookService.checkIfBookExists(bookId);
        if(bookToUpdate.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
            BeanUtils.copyProperties(bookUpdateRequestDTO,bookToUpdate);
            bookService.saveBook(bookToUpdate.get());
            return ResponseEntity.status(HttpStatus.OK).body("Book successfully edited");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable @Valid UUID bookId){
        Optional<Book> bookToDelete = bookService.checkIfBookExists(bookId);
        if(bookToDelete.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        bookService.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
    }

}
