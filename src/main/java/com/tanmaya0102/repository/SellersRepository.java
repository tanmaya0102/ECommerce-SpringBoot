package com.tanmaya0102.repository;

import com.tanmaya0102.dao.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SellersRepository extends JpaRepository<Sellers,Long> {

    @Query("SELECT seller_id from Sellers where seller_id=:seller_id and password=:password")
    Object sellerAuth(@Param("seller_id") String seller_id,@Param("password") String password);

}
