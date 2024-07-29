package com.ga5000.librarymanagement.dtos;
import java.util.List;

public record BookRequestDTO(String title,
                             String author,
                             String ISBN,
                             String publisher,
                             int yearOfPublication,
                             List<String> genres,
                             int totalCopies,
                             int availableCopies) {
}
