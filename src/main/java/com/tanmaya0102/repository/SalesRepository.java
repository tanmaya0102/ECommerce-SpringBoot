package com.tanmaya0102.repository;

import com.tanmaya0102.dao.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SalesRepository extends JpaRepository<Sales,Long> {

    @Query("SELECT s.product_id,p.product_name,p.price FROM Sales s INNER JOIN Products p on p.product_id=s.product_id where s.customer_id=:customer_id")
    List<Object> viewOrder(@RequestParam("customer_id") String customer_id);

    @Modifying
    @Query(value = "INSERT INTO Sales(product_id,customer_id) VALUES (:product_id,:customer_id)",nativeQuery = true)
    int addtoSale(@RequestParam("product_id") String product_id, @RequestParam("customer_id") String customer_id);

}
