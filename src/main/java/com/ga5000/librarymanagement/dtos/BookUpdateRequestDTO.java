package com.ga5000.librarymanagement.dtos;

import java.util.List;

public record BookUpdateRequestDTO(String title,
                                   String author,
                                   String publisher,
                                   int yearOfPublication,
                                   List<String> genres,
                                   int totalCopies,
                                   int availableCopies){}
