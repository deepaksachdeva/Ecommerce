package com.deepak.ecommerce.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("variants")
    @Expose
    private List<Variant> variants = null;
    @SerializedName("tax")
    @Expose
    private Tax tax;



//    @SerializedName("view_count")
//    @Expose
//    private Integer viewCount;
//
//    @SerializedName("order_count")
//    @Expose
//    private Integer orderCount;
//    @SerializedName("shares")
//    @Expose
//    private Integer shares;
//
//    private Integer count;


//    public Integer getViewCount() {
//        return viewCount;
//    }
//
//    public void setViewCount(Integer viewCount) {
//        this.viewCount = viewCount;
//        setCount(viewCount);
//    }


//    public Integer getOrderCount() {
//        return orderCount;
//    }
//
//    public void setOrderCount(Integer orderCount) {
//        this.orderCount = orderCount;
//        setCount(orderCount);
//    }
//
//    public Integer getShares() {
//        return shares;
//    }
//
//    public void setShares(Integer shares) {
//        this.shares = shares;
//        setCount(shares);
//    }
//
//    public void setCount(Integer count){
//        this.count = count;
//    }
//
//    public Integer getCount() {
//        return count;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

}
