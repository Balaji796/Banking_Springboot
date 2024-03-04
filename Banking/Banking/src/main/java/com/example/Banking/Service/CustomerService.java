package com.example.Banking.Service;
import com.example.Banking.Model.CustomerModel;
import com.example.Banking.Model.TransactionModel;
import com.example.Banking.Repository.CustomerRepository;
import com.example.Banking.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerrepository;
    @Autowired
    TransactionRepository transactionrepository;

    public CustomerModel createAccount(CustomerModel account) {

        return customerrepository.save(account);
    }

    public CustomerModel getAccount(long id) {
        return customerrepository.findById(id).orElse(null);
    }



    public ResponseEntity<String> deposit(long accno, long amount) {
        CustomerModel account = getAccount(accno);

        if(account == null){
            return ResponseEntity.badRequest().body("Account Not Found");
        }

        TransactionModel trans=new TransactionModel();
        trans.setAccno(accno);
        trans.setAmount(amount);
        trans.setType("Deposit");
        trans.setTransactionTime(new Date());
        transactionrepository.save(trans);
        account.setBalance(account.getBalance() + amount);
        return ResponseEntity.ok("Amount Deposited....\n"+"Account Name: "+ account.getName()+"\n"+"Account Id: "+account.getId()+"\n"+"CurrentBalance: "+account.getBalance());
    }

    public ResponseEntity<String> withdraw(long id, long amount) {
        CustomerModel account = getAccount(id);
        if(account==null){
            return ResponseEntity.badRequest().body("Account Not Found");
        }
        if (account.getBalance() < amount) {
           return ResponseEntity.badRequest().body("Insufficient funds");
        }
        if ((account.getBalance()-200) < amount) {
            return ResponseEntity.badRequest().body("Minimum Account Balance is 200/-");
        }
        TransactionModel trans=new TransactionModel();
        trans.setAccno(id);
        trans.setAmount(amount);
        trans.setType("Withdraw");
        trans.setTransactionTime(new Date());
        transactionrepository.save(trans);

        account.setBalance(account.getBalance() - amount);
         customerrepository.save(account);
         return ResponseEntity.ok("Amount Withdrawn....\n"+"Account Name: "+ account.getName()+"\n"+"Account Id: "+account.getId()+"\n"+"CurrentBalance: "+account.getBalance());
    }

    public ResponseEntity<String> deletedetails(long id){
        CustomerModel account = getAccount(id);
        if (account != null) {
            customerrepository.deleteById(id);
            return ResponseEntity.ok("Account Deleted!!");
        } else {
            return ResponseEntity.badRequest().body("No data found for Id: " + id);
        }
    }


}
