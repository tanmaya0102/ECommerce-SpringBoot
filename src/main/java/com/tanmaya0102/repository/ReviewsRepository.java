package com.tanmaya0102.repository;

import com.tanmaya0102.dao.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ReviewsRepository extends JpaRepository<Reviews,Long> {

    @Query("SELECT c.customer_name,r.review_description from Reviews r inner join Customers c on c.customer_id=r.customer_id where r.product_id=:product_id")
    List<Object> displayReviews(@RequestParam("product_id") String product_id);
}
