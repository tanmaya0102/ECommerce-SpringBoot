package com.tanmaya0102.service;

import com.tanmaya0102.dao.Reviews;
import com.tanmaya0102.request.ReviewReq;

public interface ReviewsService {
    String addReviews(Reviews reviews, ReviewReq reviewReq);
}
