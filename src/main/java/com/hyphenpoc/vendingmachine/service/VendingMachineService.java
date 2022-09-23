package com.hyphenpoc.vendingmachine.service;

import com.hyphenpoc.vendingmachine.model.Product;
import com.hyphenpoc.vendingmachine.repository.VendingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VendingMachineService {

    public List<Product> fetchproductList();

    public Product saveProduct(Product product);

    public String processPayment( Product product);

    public Optional<Product> updateProduct(int id);

    public Optional<Product> getProductById(int id);

    public String deleteProductById(int id);
}
