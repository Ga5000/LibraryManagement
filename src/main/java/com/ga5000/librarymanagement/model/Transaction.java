package com.ga5000.librarymanagement.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;

    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @Column(nullable = false)
    private Date borrowDate;

    @Column(nullable = false)
    private Date dueDate;

    @Column
    private Date returnDate;

    @Column
    private double fine;

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}
