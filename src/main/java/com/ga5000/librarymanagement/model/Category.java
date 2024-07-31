package com.ga5000.librarymanagement.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID categoryId;

    @Column(nullable = false, length = 50)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<BookCategory> bookCategories;


    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<BookCategory> getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(List<BookCategory> bookCategories) {
        this.bookCategories = bookCategories;
    }
}
