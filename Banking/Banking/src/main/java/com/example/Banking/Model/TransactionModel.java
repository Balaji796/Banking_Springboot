package com.example.Banking.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class TransactionModel {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int tid;
    private long accno;
    private double amount;
    private String type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
    private Date TransactionTime;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public long getAccno() {
        return accno;
    }

    public void setAccno(long accno) {
        this.accno = accno;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTransactionTime() {
        return TransactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        TransactionTime = transactionTime;
    }





}
