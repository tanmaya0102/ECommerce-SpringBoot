package com.tanmaya0102.controller;

import com.tanmaya0102.dao.Reviews;
import com.tanmaya0102.request.ReviewReq;
import com.tanmaya0102.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/addReview")
    public ResponseEntity<String> addReview(@RequestBody ReviewReq reviewReq)

    {
        String res;
        Reviews reviews=new Reviews();
        res=reviewsService.addReviews(reviews,reviewReq);
        return ResponseEntity.ok().body(res);
    }
}
