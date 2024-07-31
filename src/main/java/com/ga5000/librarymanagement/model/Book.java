package com.ga5000.librarymanagement.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String author;

    @Column(nullable = false, unique = true, length = 255)
    private String ISBN;

    @Column(length = 255)
    private String publisher;

    @Column
    private int yearOfPublication;

    @Column(length = 50)
    private List<String> genres;

    @Column(nullable = false)
    private int totalCopies;

    @Column(nullable = false)
    private int availableCopies;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "book")
    private List<BookCategory> bookCategories;

    public Book(){}

    public Book(String ISBN, UUID bookId, String title, String author, String publisher,
                int yearOfPublication, List<String> genres, int totalCopies, int availableCopies,
                List<Transaction> transactions, List<BookCategory> bookCategories) {
        this.ISBN = ISBN;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.genres = genres;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.transactions = transactions;
        this.bookCategories = bookCategories;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<BookCategory> getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(List<BookCategory> bookCategories) {
        this.bookCategories = bookCategories;
    }
}
