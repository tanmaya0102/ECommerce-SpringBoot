package com.tanmaya0102.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="products")
public class Products implements Serializable{
    private static final long serialVersionUID = -1162284582532726128L;
    @Id
    private Long id;

    @Column(name="product_id")
    private String product_id;
    @Column(name="seller_id")
    private String seller_id;
    @Column(name="product_name")
    private String product_name;
    @Column(name="product_description")
    private String product_description;
    @Column(name="price")
    private Float price;
    @Column(name="quantity")
    private Integer quantity;
    @Column(name="status")
    private Boolean status;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString()
    {
        return "[id=" + id + ", product_id=" + product_id + ", seller_id=" + seller_id
                + ", product_name=" + product_name +", product_description="+product_description+", price="+price+
                ", quantity="+quantity+", status=" + status + "]";

    }
}
