package com.tanmaya0102.service;

import com.tanmaya0102.dao.Customers;
import com.tanmaya0102.request.CustomerReq;

import java.util.List;

public interface CustomersService {
    List<Customers> findAll();
    String registerCustomer(Customers customers, CustomerReq customerReq);
    Boolean checkCustomer(String customer_id,String password);
    List<Object> displayProducts(String customer_id, String password);
    List<Object> displayProductDetail(String customer_id, String password,String product_id);
    String addtoCart(String customer_id, String password,String product_id);
    List<Object> viewCart(String customer_id,String password);
}
