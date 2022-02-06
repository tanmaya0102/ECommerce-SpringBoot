package com.tanmaya0102.request;

import java.io.Serializable;

public class CustomerReq implements Serializable {
    private static final long serialVersionUID = 3953322116230627858L;

    private String customer_id;

    private String customer_name;

    private String password;

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
