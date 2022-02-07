package com.tanmaya0102.dao;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="sales")
public class Sales implements Serializable {
    private static final long serialVersionUID = -3161563511179979179L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="product_id")
    private String product_id;

    @Column(name="customer_id")
    private String customer_id;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

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
}
