package com.tanmaya0102.service.impl;

import com.tanmaya0102.dao.Products;
import com.tanmaya0102.repository.ProductsRepository;
import com.tanmaya0102.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }
}
