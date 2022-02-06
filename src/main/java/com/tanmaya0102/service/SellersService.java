package com.tanmaya0102.service;

import com.tanmaya0102.dao.Products;
import com.tanmaya0102.dao.Sellers;
import com.tanmaya0102.request.ProductReq;
import com.tanmaya0102.request.SellerReq;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SellersService {
    List<Sellers> findAll();
    String registerSeller(Sellers sellers, SellerReq sellerReq);
    Boolean checkSeller(String seller_id,String password);
    String addProducts(String seller_id,String password,Products products, ProductReq productReq);
    List<Object> viewProducts(String seller_id,String password);
    String deleteProduct(String seller_id,String password,String product_id);
    String updateProduct(String seller_id,String password,String product_id,Float price,Integer quantity,Boolean status);

}
