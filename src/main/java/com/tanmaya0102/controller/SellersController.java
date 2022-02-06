package com.tanmaya0102.controller;

import com.tanmaya0102.dao.Sellers;
import com.tanmaya0102.service.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellersController {
    @Autowired
    private SellersService sellersService;


    @GetMapping("/getSellers")
    public ResponseEntity<List<Sellers>> getSellers()
    {
        List<Sellers> sellersList=sellersService.findAll();
        return ResponseEntity.ok().body(sellersList);
    }
}
