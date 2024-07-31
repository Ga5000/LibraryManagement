package com.ga5000.librarymanagement.controllers;

import com.ga5000.librarymanagement.dtos.MemberRequestDTO;
import com.ga5000.librarymanagement.dtos.MemberUpdateRequestDTO;
import com.ga5000.librarymanagement.model.Member;
import com.ga5000.librarymanagement.model.Transaction;
import com.ga5000.librarymanagement.model.User;
import com.ga5000.librarymanagement.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Object> createMember(@RequestBody @Valid MemberRequestDTO memberRequestDTO){
        var newMember = new Member();
        BeanUtils.copyProperties(memberRequestDTO,newMember);
        newMember.setMembershipDate(Date.from(Instant.now()));
        newMember.setMembershipStatus("active");
        //newMember.setUser();

        memberService.saveMember(newMember);
        return ResponseEntity.status(HttpStatus.CREATED).body("Membership successfully created");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> updateMember(@PathVariable("id") UUID memberId, @RequestBody @Valid MemberUpdateRequestDTO memberUpdateRequestDTO){
        Optional<Member> memberToUpdate = memberService.checkIfMemberExists(memberId);
        if(memberToUpdate.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member not found");
        }
            memberService.saveMember(memberToUpdate.get());
            return ResponseEntity.status(HttpStatus.OK).body("Member edited successfully");

    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Object> getMemberTransactions(@PathVariable("id") UUID memberId){
        Optional<Member> memberOptional = memberService.checkIfMemberExists(memberId);
        if(memberOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member not found");
        }
            return ResponseEntity.status(HttpStatus.OK).body(memberService.getMemberTransactions(memberId));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteMember(@PathVariable("id") UUID memberId){
        Optional<Member> memberToDelete = memberService.checkIfMemberExists(memberId);
        if(memberToDelete.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member not found");
        }
            memberService.deleteMember(memberId);
            return ResponseEntity.status(HttpStatus.OK).body("Member deleted successfully");
    }


}
