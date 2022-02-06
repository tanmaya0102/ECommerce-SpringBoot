package com.tanmaya0102.service;

import com.tanmaya0102.dao.Customers;
import com.tanmaya0102.request.CustomerReq;

import java.util.List;

public interface CustomersService {
    List<Customers> findAll();
    String registerCustomer(Customers customers, CustomerReq customerReq);
    Boolean checkCustomer(String customer_id,String password);
}
