package com.example.Banking.Controller;

import com.example.Banking.Model.CustomerModel;
import com.example.Banking.Model.TransactionModel;
import com.example.Banking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerservice;

    @PostMapping("/add")
    public CustomerModel createAccount(@RequestBody CustomerModel account) {
        return customerservice.createAccount(account);
    }
    @GetMapping("/{id}")
    public CustomerModel getAccount(@PathVariable long id) {
        return customerservice.getAccount(id);
    }

    @GetMapping("/{id}/deposit/{deposit}")
    public ResponseEntity<String> deposit(@PathVariable long id, @PathVariable Long deposit) {
        return customerservice.deposit(id, deposit);
    }

    @GetMapping("/{id}/withdraw/{withdraw}")
    public ResponseEntity<String> withdraw(@PathVariable long id, @PathVariable Long withdraw) {
        return customerservice.withdraw(id, withdraw);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        return customerservice.deletedetails(id);
    }


}

