package com.tanmaya0102.controller;

import com.tanmaya0102.dao.Sellers;
import com.tanmaya0102.request.SellerReq;
import com.tanmaya0102.service.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/registerSeller")
    public ResponseEntity<String> registerSeller(@RequestBody SellerReq sellerReq)
    {
        Sellers sellers = new Sellers();
        String res;
       try{
           res=sellersService.registerSeller(sellers,sellerReq);
       }
       catch(Exception e)
       {
           res= HttpStatus.INTERNAL_SERVER_ERROR.toString();

       }
       return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }
}
