package com.ga5000.librarymanagement.services;

import com.ga5000.librarymanagement.model.Member;
import com.ga5000.librarymanagement.model.Transaction;
import com.ga5000.librarymanagement.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void saveMember(Member member){
        memberRepository.save(member);
    }

    public void deleteMember(UUID id){
        memberRepository.deleteById(id);
    }

    public List<Transaction> getMemberTransactions(UUID id){
        return memberRepository.findMemberTransactionsById(id);
    }

}
