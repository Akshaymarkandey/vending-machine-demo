package com.hyphenpoc.vendingmachine.serviceimpl;

import com.hyphenpoc.vendingmachine.model.Product;
import com.hyphenpoc.vendingmachine.repository.VendingMachineRepository;
import com.hyphenpoc.vendingmachine.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {


    @Autowired
    private VendingMachineRepository vendingMachineRepository;

    public List<Product> fetchproductList() {

        return vendingMachineRepository.findAll();


    }

    public Product saveProduct(Product product) {
        return vendingMachineRepository.save(product);
    }

    public String processPayment(Product product) {
        String url = "https://securegw-stage.paytm.in/order/process";

        return url;
    }


    public Optional<Product> updateProduct(int id) {
        return vendingMachineRepository.findById(id);
    }

    public Optional<Product> getProductById(int id) {
        return vendingMachineRepository.findById(id);
    }

    public String deleteProductById(int id) {

        String result;
        try {
            vendingMachineRepository.deleteById(id);
            result = "Product Removed Succesfully";
        } catch (IllegalArgumentException e) {

            result = "Please select appropriate Product to remove";
        }
        return result;

    }
}
