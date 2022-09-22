package com.hyphenpoc.vendingmachine.repository;

import com.hyphenpoc.vendingmachine.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendingMachineRepository extends JpaRepository<Product, Integer> {

}
