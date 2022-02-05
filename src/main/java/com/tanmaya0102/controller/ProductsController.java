package com.tanmaya0102.controller;

import com.tanmaya0102.dao.Products;
import com.tanmaya0102.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {


    @Autowired
    private ProductsService productsService;


    @GetMapping("/getProducts")
    public ResponseEntity<List<Products>> getProducts()
    {
        List<Products> productsList=productsService.findAll();
        return ResponseEntity.ok().body(productsList);
    }
}
