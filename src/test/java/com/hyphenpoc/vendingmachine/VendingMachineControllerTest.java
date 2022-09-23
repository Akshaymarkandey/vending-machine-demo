package com.hyphenpoc.vendingmachine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.hyphenpoc.vendingmachine.controller.VendingMachineController;
import com.hyphenpoc.vendingmachine.model.Product;
import com.hyphenpoc.vendingmachine.repository.VendingMachineRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineControllerTest {


    private MockMvc mockMVC;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();


    @Mock
    VendingMachineRepository vendingMachineRepository;

    @InjectMocks
    private VendingMachineController vendingMachineController;

    Product product1 = new Product(1,"Cafe Latte","Mike Based Coffee",200);
    Product product2 = new Product(2,"Lemon Tea","Lemon Flavored Tea",150);
    Product product3 = new Product(3,"Ice Tea","Iced Tea",180);


    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        this.mockMVC = MockMvcBuilders.standaloneSetup(vendingMachineController).build();
    }

    @Test
    @Order(1)
    public void fetchProductList_success() throws Exception {
        List<Product> products = new ArrayList<>(Arrays.asList(product1,product2,product3));
        Mockito.when(vendingMachineRepository.findAll()).thenReturn(products);

        mockMVC.perform(MockMvcRequestBuilders.get("/products").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.jsonPath("$[2].productName", is("Lemon Tea")))
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)));
    }

    @Test
    @Order(2)
    public void saveEmployeeTest(){

        Product product = Product.builder()
        .productId(5)
        .productName("Green Tea")
        .productDesc("Detox Green Tea")
        .productPrice(100).build();
        vendingMachineRepository.save(product);
        Assertions.assertThat(product.getProductId()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void updateEmployeeTest(){

        Product product = vendingMachineRepository.findById(1).get();
        product.setProductName("cappuccino");
        Product productUpdated =  vendingMachineRepository.save(product);
        Assertions.assertThat(productUpdated.getProductName()).isEqualTo("cappuccino");
    }


    @Test
    @Order(4)
    public void deleteEmployeeTest(){

        Product product = vendingMachineRepository.findById(3).get();
        vendingMachineRepository.delete(product);
        Product product1 = null;
        Optional<Product> optionalEmployee = vendingMachineRepository.findById(3);
        if(optionalEmployee.isPresent()){
            product1 = optionalEmployee.get();
        }
        Assertions.assertThat(product1).isNull();
    }
}
