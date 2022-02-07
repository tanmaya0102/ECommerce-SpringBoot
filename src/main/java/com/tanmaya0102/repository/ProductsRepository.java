package com.tanmaya0102.repository;

import com.tanmaya0102.dao.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@Transactional
public interface ProductsRepository extends JpaRepository<Products,Long> {

    @Query("SELECT product_id,seller_id,product_name,product_description,price,quantity,status FROM Products WHERE seller_id=:seller_id")
    List<Object> viewProducts(@RequestParam("seller_id") String seller_id);

    @Modifying
    @Query("UPDATE Products SET status=false WHERE seller_id=:seller_id AND product_id=:product_id")
    int deleteProduct(@RequestParam("seller_id") String seller_id,@RequestParam("product_id") String product_id);

    @Modifying
    @Query("UPDATE Products SET status=:status,price=:price,quantity=:quantity WHERE seller_id=:seller_id AND product_id=:product_id")
    int updateProduct(@RequestParam("seller_id") String seller_id,@RequestParam("product_id") String product_id,
                      @RequestParam("price") Float price,@RequestParam("quantity")Integer quantity,
                      @RequestParam("status") Boolean status);

    @Query("SELECT product_id,product_name,product_description,price FROM Products WHERE status=true")
    List<Object> displayProducts();

    @Query("SELECT p.product_id,p.product_name,p.product_description,p.price,s.seller_name FROM Products p join Sellers s on s.seller_id=p.seller_id where p.product_id=:product_id")
    List<Object> displayProductDetail(@RequestParam("product_id") String product_id);
}
