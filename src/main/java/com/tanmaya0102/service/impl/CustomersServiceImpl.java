package com.tanmaya0102.service.impl;

import com.tanmaya0102.dao.Customers;
import com.tanmaya0102.repository.CustomersRepository;
import com.tanmaya0102.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public List<Customers> findAll() {
        return customersRepository.findAll();
    }
}
