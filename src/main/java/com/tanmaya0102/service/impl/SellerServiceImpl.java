package com.tanmaya0102.service.impl;


import com.tanmaya0102.dao.Sellers;
import com.tanmaya0102.repository.SellersRepository;
import com.tanmaya0102.service.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellersService {
    @Autowired
    private SellersRepository sellersRepository;

    @Override
    public List<Sellers> findAll() {
        return sellersRepository.findAll();
    }
}

