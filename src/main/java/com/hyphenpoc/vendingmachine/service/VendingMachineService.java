package com.hyphenpoc.vendingmachine.service;

import com.hyphenpoc.vendingmachine.model.Product;
import com.hyphenpoc.vendingmachine.repository.VendingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendingMachineService {

    @Autowired
    private VendingMachineRepository vendingMachineRepository;
    public List<Product> fetchproductList(){

        return vendingMachineRepository.findAll();


    }

    public Product saveProduct(Product product)
    {
       return vendingMachineRepository.save(product);
    }

    public Optional<Product> getProductById(int id)
    {
        return vendingMachineRepository.findById(id);
    }

    public String deleteProductById(int id)
    {

        String result;
        try {
            vendingMachineRepository.deleteById(id);
            result = "Product Removed Succesfully";
        } catch (IllegalArgumentException e){

            result = "Please select appropriate Product to remove";
        }
        return result;
    }
}
