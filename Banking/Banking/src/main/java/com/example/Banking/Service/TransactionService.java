package com.example.Banking.Service;

import com.example.Banking.Model.TransactionModel;
import com.example.Banking.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TransactionService {

    @Autowired
    TransactionRepository transrepository;

    public List<TransactionModel> getAllDetails() {
        return transrepository.findAll();

    }
    public List<TransactionModel> getaccountdetails(int accno){
        return transrepository.getdetails(accno);
    }
    public List<TransactionModel> timeDetails(String first, String second){
        return transrepository.getAll(first,second);
    }
}


