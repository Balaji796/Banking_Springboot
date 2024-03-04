package com.example.Banking.Repository;

import com.example.Banking.Model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
    @Query("select t from TransactionModel t where t.accno=:accno")
    List<TransactionModel> getdetails(int accno);
    @Query("select t from TransactionModel t where t.TransactionTime between :first and :second")
    List<TransactionModel> getAll(String first,String second);
}
