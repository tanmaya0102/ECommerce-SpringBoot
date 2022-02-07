package com.tanmaya0102.repository;

import com.tanmaya0102.dao.Carts;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CartsRepository extends JpaRepository<Carts,Long> {

    @Modifying
    @Query(value = "INSERT INTO CARTS(product_id,customer_id,bought) VALUES(:product_id,:customer_id,false)",nativeQuery = true)
    int addtoCart(@RequestParam("product_id") String product_id,@RequestParam("customer_id") String customer_id);

    @Query("SELECT c.product_id,p.product_name,p.price FROM Carts c INNER JOIN Products p on p.product_id=c.product_id WHERE c.bought=false AND c.customer_id=:customer_id")
    List<Object> viewCart(@RequestParam("customer_id") String customer_id);

}
