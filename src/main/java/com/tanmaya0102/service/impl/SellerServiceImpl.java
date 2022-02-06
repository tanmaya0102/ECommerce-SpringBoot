package com.tanmaya0102.service.impl;


import com.tanmaya0102.dao.Sellers;
import com.tanmaya0102.repository.SellersRepository;
import com.tanmaya0102.request.SellerReq;
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

    @Override
    public String registerSeller(Sellers sellers, SellerReq sellerReq) {
        sellers.setSeller_id(sellerReq.getSeller_id());
        sellers.setSeller_name(sellerReq.getSeller_name());
        sellers.setPassword(sellerReq.getPassword());
        sellersRepository.save(sellers);
        return "Seller Registered";
    }
}

