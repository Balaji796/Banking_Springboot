package com.example.Banking.Repository;

import com.example.Banking.Model.CustomerModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM CustomerModel c WHERE c.id = :id")
    void deleteById(int id);
}
