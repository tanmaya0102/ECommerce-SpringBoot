package com.tanmaya0102.repository;

import com.tanmaya0102.dao.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomersRepository extends JpaRepository<Customers,Long> {
    @Query("SELECT customer_id from Customers where customer_id=:customer_id and password=:password")
    Object customerAuth(@Param("customer_id") String customer_id, @Param("password") String password);
}
