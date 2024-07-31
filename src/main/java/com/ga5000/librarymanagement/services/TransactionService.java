package com.ga5000.librarymanagement.services;

import com.ga5000.librarymanagement.model.Transaction;
import com.ga5000.librarymanagement.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void saveTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }

    @Transactional
    public void deleteTransaction(UUID id){
        transactionRepository.deleteById(id);
    }
}
