package com.tanmaya0102.request;

import java.io.Serializable;

public class SellerReq implements Serializable {

    private static final long serialVersionUID = 4172354310383674027L;

    private String seller_id;
    private String seller_name;
    private String password;
    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
