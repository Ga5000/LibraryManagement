package com.ga5000.librarymanagement.controllers;

import com.ga5000.librarymanagement.model.Member;
import com.ga5000.librarymanagement.model.Transaction;
import com.ga5000.librarymanagement.services.BookService;
import com.ga5000.librarymanagement.services.MemberService;
import com.ga5000.librarymanagement.services.TransactionService;
import com.ga5000.librarymanagement.dtos.TransactionRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;
    private final BookService bookService;
    private final MemberService memberService;

    public TransactionController(TransactionService transactionService, BookService bookService, MemberService memberService) {
        this.transactionService = transactionService;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    @PostMapping("/create/{memberId}")
    public ResponseEntity<Object> createTransaction(@PathVariable("id") UUID memberId, @RequestBody @Valid TransactionRequestDTO transactionRequestDTO){
        var newTransaction = new Transaction();
        newTransaction.setBook(bookService.findBookByISBN(transactionRequestDTO.ISBN()));
        newTransaction.setBorrowDate(Date.from(Instant.now()));
        newTransaction.setDueDate(transactionRequestDTO.dueDate());
        newTransaction.setReturnDate(transactionRequestDTO.returnDate());

        newTransaction.setMember(memberService.getMemberById(memberId));

        transactionService.saveTransaction(newTransaction);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transaction successfully made");

    }
}
