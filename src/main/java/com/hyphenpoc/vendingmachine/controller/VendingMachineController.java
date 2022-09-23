package com.hyphenpoc.vendingmachine.controller;

import com.hyphenpoc.vendingmachine.exception.ResourceNotFoundException;
import com.hyphenpoc.vendingmachine.model.Product;
import com.hyphenpoc.vendingmachine.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Used @CrossOrigin because we where getting the CORS Error.
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VendingMachineController {

    @Autowired
    private VendingMachineService vendingMachineService;


    // fetch all products.
    @GetMapping("/getproductlist")
    public List<Product> fetchProductList() {

        List<Product> products = new ArrayList<>();
        //Logic to fetch list from database.
        products = vendingMachineService.fetchproductList();
        return products;
    }

    //create new product
    @PostMapping("/addproduct")
    public Product saveProduct(@RequestBody Product product) {

        return  vendingMachineService.saveProduct(product);

    }

    //get product details by id
    @GetMapping("/getproductbyid/{id}")
    public Product getProductById(@PathVariable int id) {

        return vendingMachineService.getProductById(id).get();

    }

    // update product rest api

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Product> updateEmployee(@PathVariable int id, @RequestBody Product productDetails){
        Product product = vendingMachineService.updateProduct(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id :" + id));

        product.setProductName(productDetails.getProductName());
        product.setProductDesc(productDetails.getProductDesc());
        product.setProductPrice(productDetails.getProductPrice());

        Product updatedProduct = vendingMachineService.saveProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // delete product rest api
    @DeleteMapping("/deleteproductbyid/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
        Product product = vendingMachineService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        vendingMachineService.deleteProductById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
