package com.tanmaya0102.controller;

import com.tanmaya0102.dao.Products;
import com.tanmaya0102.dao.Sellers;
import com.tanmaya0102.request.ProductReq;
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
    public ResponseEntity<List<Sellers>> getSellers() {
        List<Sellers> sellersList = sellersService.findAll();
        return ResponseEntity.ok().body(sellersList);
    }

    @PostMapping("/registerSeller")
    public ResponseEntity<String> registerSeller(@RequestBody SellerReq sellerReq) {
        Sellers sellers = new Sellers();
        String res;
        try {
            res = sellersService.registerSeller(sellers, sellerReq);
        } catch (Exception e) {
            res = HttpStatus.INTERNAL_SERVER_ERROR.toString();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @GetMapping("/checkSeller")
    public ResponseEntity<String> checkSeller(@RequestParam String seller_id, @RequestParam String password) {
        if (sellersService.checkSeller(seller_id, password)) {
            return ResponseEntity.status(HttpStatus.OK).body("Seller Authenticated");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Incorrect SellerId or Password");
        }
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestParam String seller_id, @RequestParam String password, @RequestBody ProductReq productReq)
    {
        Products products=new Products();
        String res;
        try
        {
            res=sellersService.addProducts(seller_id,password,products,productReq);
        }catch (Exception e) {
            res = HttpStatus.INTERNAL_SERVER_ERROR.toString();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @GetMapping("/viewProductsListed")
    public ResponseEntity<List<Object>> viewProduct(@RequestParam String seller_id, @RequestParam String password)
    {
        List<Object> productReqList;
        productReqList=sellersService.viewProducts(seller_id,password);
        return ResponseEntity.status(HttpStatus.OK).body(productReqList);

    }
    
    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteProduct(@RequestParam String seller_id, @RequestParam String password,@RequestParam String product_id)
    {
        String res = "Error Occured";
        try
        {
            res=sellersService.deleteProduct(seller_id,password,product_id);
            return ResponseEntity.ok().body(res);
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().body(res);
        }
    }
    @PatchMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestParam String seller_id, @RequestParam String password,@RequestParam String product_id,
                                                @RequestParam("price") Float price,@RequestParam("quantity")Integer quantity,@RequestParam("status") Boolean status)
    {
        String res = "Error Occured";
        try
        {
            res=sellersService.updateProduct(seller_id,password,product_id,price,quantity,status);
            return ResponseEntity.ok().body(res);
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().body(res);
        }
    }


}
