package com.example.Banking.Controller;

import com.example.Banking.Model.TransactionModel;
import com.example.Banking.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
    @Autowired
    TransactionService transservice;

    //Get the details of all TRANSACTIONS
    @GetMapping("/getalltransactions")
    public List<TransactionModel> getAll(){
        return transservice.getAllDetails();
    }

    //Get the details of given Account number Transactions
   @GetMapping("/getaccounttransactions/{accno}")
   public List<TransactionModel> getAccountDetails(@PathVariable int accno){
        return transservice.getaccountdetails(accno);
    }
    @GetMapping("/{first}/{second}")
    public List<TransactionModel> get(@PathVariable String first, @PathVariable String second){
        return transservice.timeDetails(first,second);
    }

}
