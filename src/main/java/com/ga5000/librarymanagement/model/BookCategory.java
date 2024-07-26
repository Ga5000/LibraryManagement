package com.ga5000.librarymanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookCategories")
@IdClass(BookCategoryId.class)
public class BookCategory {

    @Id
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
