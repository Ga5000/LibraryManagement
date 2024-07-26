package com.ga5000.librarymanagement.repositories;

import com.ga5000.librarymanagement.model.Member;
import com.ga5000.librarymanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    @Query("SELECT t FROM Transaction t WHERE t.member.memberId = :id")
    List<Transaction> findMemberTransactionsById(UUID id);
}
