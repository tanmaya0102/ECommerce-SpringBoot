package com.tanmaya0102.repository;

import com.tanmaya0102.dao.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductsRepository extends JpaRepository<Products,Long> {
}
