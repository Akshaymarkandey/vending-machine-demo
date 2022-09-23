package com.hyphenpoc.vendingmachine.repository;

import com.hyphenpoc.vendingmachine.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment , Integer> {

    Payment findByTxnId(String txnId);
}
