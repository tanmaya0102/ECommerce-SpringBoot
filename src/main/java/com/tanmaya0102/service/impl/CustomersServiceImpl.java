package com.tanmaya0102.service.impl;

import com.tanmaya0102.dao.Customers;
import com.tanmaya0102.repository.*;
import com.tanmaya0102.request.CustomerReq;
import com.tanmaya0102.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public List<Customers> findAll() {
        return customersRepository.findAll();
    }

    @Override
    public String registerCustomer(Customers customers, CustomerReq customerReq) {
        customers.setCustomer_id(customerReq.getCustomer_id());
        customers.setCustomer_name(customerReq.getCustomer_name());
        customers.setPassword(customerReq.getPassword());
        customersRepository.save(customers);
        return "Customer Registered";
    }

    @Override
    public Boolean checkCustomer(String customer_id, String password) {
        Object customer = customersRepository.customerAuth(customer_id, password);
        return customer != null;
    }

    @Override
    public List<Object> displayProducts(String customer_id, String password) {
        if (checkCustomer(customer_id, password)) {
            List<Object> productList;
            productList = productsRepository.displayProducts();
            return productList;
        } else {
            return null;
        }
    }

    @Override
    public List<Object> displayProductDetail(String customer_id, String password, String product_id) {
        List<Object> res;
        List<Object> rev;
        if (checkCustomer(customer_id, password)) {
            res = productsRepository.displayProductDetail(product_id);
            rev = reviewsRepository.displayReviews(product_id);
            res.add(rev);
            return res;
        } else {
            return null;
        }

    }

    @Override
    public String addtoCart(String customer_id, String password, String product_id) {
        int res = 0;
        if (checkCustomer(customer_id, password)) {
             res=cartsRepository.addtoCart(product_id, customer_id);
            return res + " product added to cart";
        } else {
            return res + " product added to cart";
        }

    }

    @Override
    public List<Object> viewCart(String customer_id, String password) {
        List<Object> res;
        if (checkCustomer(customer_id, password)) {
            res = cartsRepository.viewCart(customer_id);
            return res;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Object> viewOrders(String customer_id, String password) {
        List<Object> res;
        if (checkCustomer(customer_id, password)) {
            res = salesRepository.viewOrder(customer_id);
            return res;
        }
        else {
            return null;
        }

    }

    @Override
    public String buyProducts(String customer_id, String password) {
        List<String> productList;
        int count=0,c;
        if (checkCustomer(customer_id, password)) {
            productList = cartsRepository.getCart(customer_id);
            for(int i=0;i<productList.size();i++)
            {
                c= salesRepository.addtoSale(productList.get(i),customer_id);
                cartsRepository.updateCart(productList.get(i),customer_id);
                productsRepository.updateProductQuantity(productList.get(i));
                count+=c;
            }
           return count +" products are bought";
        }
        else {
            return null;
        }
    }


}
