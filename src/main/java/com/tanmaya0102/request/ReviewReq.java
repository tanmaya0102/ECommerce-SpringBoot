package com.tanmaya0102.request;

import java.io.Serializable;

public class ReviewReq implements Serializable {
    private static final long serialVersionUID = 7115489372017688955L;

    private String product_id;


    private String customer_id;

    private String review_description;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getReview_description() {
        return review_description;
    }

    public void setReview_description(String review_description) {
        this.review_description = review_description;
    }
}
