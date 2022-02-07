package com.tanmaya0102.service.impl;

import com.tanmaya0102.dao.Reviews;
import com.tanmaya0102.repository.ReviewsRepository;
import com.tanmaya0102.request.ReviewReq;
import com.tanmaya0102.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewsServiceImpl implements ReviewsService {
    @Autowired
    private ReviewsRepository reviewsRepository;
    @Override
    public String addReviews(Reviews reviews, ReviewReq reviewReq) {
        try {
            reviews.setProduct_id(reviewReq.getProduct_id());
            reviews.setCustomer_id(reviewReq.getCustomer_id());
            reviews.setReview_description(reviewReq.getReview_description());
            reviewsRepository.save(reviews);
            return "Review is added";
        }catch (Exception e)
        {
            return "Review is not added";
        }
    }
}
