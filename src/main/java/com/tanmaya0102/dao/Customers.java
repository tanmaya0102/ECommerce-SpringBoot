package com.tanmaya0102.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="customers")
public class Customers implements Serializable {

    private static final long serialVersionUID = 1967562370911425136L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="customer_id")
    private String customer_id;

    @Column(name="customer_name")
    private String customer_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Column(name="password")
    private String password;
}
