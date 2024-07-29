package com.ga5000.librarymanagement.model;

import com.ga5000.librarymanagement.security.UserRole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    
    @Column(nullable = false, length = 60)
    private String username;
    
    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private UserRole role;

    @OneToOne
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member memberAccount;


    public User(){}

    public User(UUID userId, String username, String password, UserRole role, Member memberAccount) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.memberAccount = memberAccount;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Member getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(Member memberAccount) {
        this.memberAccount = memberAccount;
    }
}
