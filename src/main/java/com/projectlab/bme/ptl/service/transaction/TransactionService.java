package com.projectlab.bme.ptl.service.transaction;

import com.projectlab.bme.ptl.entity.Transaction;

import java.util.List;

public interface TransactionService {

    public List<Transaction> findAll();

    public Transaction findById(int theId);

    public void save(Transaction theTransaction);

    public void deleteById(int theId);

}
