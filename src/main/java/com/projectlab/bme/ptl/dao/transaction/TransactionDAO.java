package com.projectlab.bme.ptl.dao.transaction;

import com.projectlab.bme.ptl.entity.Transaction;

import java.util.List;

public interface TransactionDAO {


    public List<Transaction> findAll();

    public Transaction findById(int theId);

    public void save(Transaction theTransaction);

    public void deleteById(int theId);

}
