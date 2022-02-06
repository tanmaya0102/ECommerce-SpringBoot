package com.tanmaya0102.controller;

import com.tanmaya0102.dao.Customers;
import com.tanmaya0102.dao.Products;
import com.tanmaya0102.service.CustomersService;
import com.tanmaya0102.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController {
    @Autowired
    private CustomersService customersService;


    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customers>> getCustomers()
    {
        List<Customers> customersList=customersService.findAll();
        return ResponseEntity.ok().body(customersList);
    }
}
