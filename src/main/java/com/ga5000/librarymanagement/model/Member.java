package com.ga5000.librarymanagement.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "members")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID memberId;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(length = 255)
    private String address;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 100)
    private String email;

    @Column(nullable = false)
    private Date membershipDate;

    @Column(nullable = false, length = 20)
    private String membershipStatus;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "member")
    private List<Transaction> transactions;

    public Member() {
    }

    public Member(String firstName, String lastName, Date dateOfBirth, String address, String phoneNumber, String email, Date membershipDate, String membershipStatus, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.membershipDate = membershipDate;
        this.membershipStatus = membershipStatus;
        this.user = user;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
