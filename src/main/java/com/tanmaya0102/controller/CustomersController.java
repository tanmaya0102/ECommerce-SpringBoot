package com.tanmaya0102.controller;

import com.tanmaya0102.dao.Customers;
import com.tanmaya0102.request.CustomerReq;
import com.tanmaya0102.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/registerCustomer")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerReq customerReq)
    {
        Customers customers = new Customers();
        String res;
        try{
            res=customersService.registerCustomer(customers,customerReq);
        }
        catch(Exception e)
        {
            res= HttpStatus.INTERNAL_SERVER_ERROR.toString();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @GetMapping("/checkCustomer")
    public ResponseEntity<String> checkCustomer(@RequestParam String customer_id, @RequestParam String password)
    {
        if(customersService.checkCustomer(customer_id,password))
        {
            return ResponseEntity.status(HttpStatus.OK).body("Customer Authenticated");
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Incorrect CustomerId or Password");
        }
    }

    @GetMapping("/displayProducts")
    public ResponseEntity<List<Object>> displayProduct(@RequestParam String customer_id, @RequestParam String password)
    {
        List<Object> productList;
        productList=customersService.displayProducts(customer_id,password);
        return ResponseEntity.status(HttpStatus.OK).body(productList);

    }

    @GetMapping("/displayProductDetail")
    public ResponseEntity<List<Object>> displayProductDetail(@RequestParam String customer_id, @RequestParam String password,@RequestParam String product_id)
    {
        List<Object> productList;
        productList=customersService.displayProductDetail(customer_id,password,product_id);
        return ResponseEntity.status(HttpStatus.OK).body(productList);

    }

    @GetMapping("/addToCart")
    public ResponseEntity<String> addtoCart(@RequestParam String customer_id, @RequestParam String password,@RequestParam String product_id)
    {
        String res;
        res=customersService.addtoCart(customer_id,password,product_id);
        return ResponseEntity.status(HttpStatus.OK).body(res);

    }


    @GetMapping("/viewCart")
    public ResponseEntity<List<Object>> viewCart(@RequestParam String customer_id, @RequestParam String password)
    {
        List<Object> cartList;
        cartList=customersService.viewCart(customer_id,password);
        return ResponseEntity.status(HttpStatus.OK).body(cartList);

    }
}
