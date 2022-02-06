package com.tanmaya0102.service.impl;


import com.tanmaya0102.dao.Products;
import com.tanmaya0102.dao.Sellers;
import com.tanmaya0102.repository.ProductsRepository;
import com.tanmaya0102.repository.SellersRepository;
import com.tanmaya0102.request.ProductReq;
import com.tanmaya0102.request.SellerReq;
import com.tanmaya0102.service.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellersService {
    @Autowired
    private SellersRepository sellersRepository;

    @Autowired
    private ProductsRepository productsRepository;

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

    @Override
    public Boolean checkSeller(String seller_id,String password) {

        Object seller=sellersRepository.sellerAuth(seller_id,password);
        return seller != null;
    }

    @Override
    public String addProducts(String seller_id,String password,Products products, ProductReq productReq) {
        if(checkSeller(seller_id,password))
        {
            products.setProduct_id(productReq.getProduct_id());
            products.setProduct_name(productReq.getProduct_name());
            products.setSeller_id(productReq.getSeller_id());
            products.setProduct_description(productReq.getProduct_description());
            products.setPrice(productReq.getPrice());
            products.setQuantity(productReq.getQuantity());
            products.setStatus(productReq.getStatus());
            productsRepository.save(products);
            return "Product is added";
        }
        else{
            return "Error Occurred";
        }
    }

    @Override
    public List<Object> viewProducts(String seller_id, String password) {
        if(checkSeller(seller_id,password))
        {   List<Object> productReqList;
            productReqList=productsRepository.viewProducts(seller_id);
            return productReqList;
        }
        else{
            return null;
        }
    }

    @Override
    public String deleteProduct(String seller_id, String password, String product_id) {
        if(checkSeller(seller_id,password))
        {   int integer;
            integer=productsRepository.deleteProduct(seller_id,product_id);
            return integer+" product deleted";
        }
        else{
            return "Error Occurred";
        }

    }

    @Override
    public String updateProduct(String seller_id, String password, String product_id, Float price, Integer quantity, Boolean status) {
        if(checkSeller(seller_id,password))
        {   int integer;
            integer=productsRepository.updateProduct(seller_id,product_id,price,quantity,status);
            return integer+" product updated";
        }
        else{
            return "Error Occurred";
        }
    }
}

