package com.ga5000.librarymanagement.dtos;

import java.util.Date;

public record TransactionRequestDTO(String ISBN,Date dueDate, Date returnDate, double fine) {
}
