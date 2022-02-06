package com.tanmaya0102.repository;

import com.tanmaya0102.dao.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomersRepository extends JpaRepository<Customers,Long> {
}
