package com.hyphenpoc.vendingmachine.controller;

import com.hyphenpoc.vendingmachine.model.Product;
import com.hyphenpoc.vendingmachine.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VendingMachineController {

    @Autowired
    private VendingMachineService vendingMachineService;

    //@RequestMapping(path = "/getproductlist", method = RequestMethod.GET)
    @GetMapping("/getproductlist")
    public List<Product> fetchProductList() {

        List<Product> products = new ArrayList<>();
        //Logic to fetch list from database.
        products = vendingMachineService.fetchproductList();
        return products;
    }

    @PostMapping("/addproduct")
    public Product saveProduct(@RequestBody Product product) {

        return  vendingMachineService.saveProduct(product);

    }

    @GetMapping("/getproductbyid/{id}")
    public Product getProductById(@PathVariable int id) {

        return vendingMachineService.getProductById(id).get();

    }

    @DeleteMapping("/deleteproductbyid/{id}")
    public String deleteProductById(@PathVariable int id) {

       return vendingMachineService.deleteProductById(id);

    }

}
