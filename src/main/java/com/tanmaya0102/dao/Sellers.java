package com.tanmaya0102.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="sellers")
public class Sellers implements Serializable {
    private static final long serialVersionUID = -5665322798169993515L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="seller_id")
    private String seller_id;

    @Column(name="seller_name")
    private String seller_name;

    @Column(name="password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
