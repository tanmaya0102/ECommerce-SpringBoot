package com.tanmaya0102.service;

import com.tanmaya0102.dao.Sellers;
import com.tanmaya0102.request.SellerReq;

import java.util.List;

public interface SellersService {
    List<Sellers> findAll();
    String registerSeller(Sellers sellers, SellerReq sellerReq);
    Boolean checkSeller(String seller_id,String password);
}
