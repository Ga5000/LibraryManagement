package com.ga5000.librarymanagement.model;

import java.io.Serializable;
import java.util.UUID;

public class BookCategoryId implements Serializable {
    private UUID book;
    private UUID category;

    public BookCategoryId(){}

    public UUID getBook() {
        return book;
    }

    public void setBook(UUID book) {
        this.book = book;
    }

    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }
}
