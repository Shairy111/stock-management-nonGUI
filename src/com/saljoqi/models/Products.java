package com.saljoqi.models;

public class Products {
    private int product_id;
    private String product_name;
    private float product_price;
    private int count_in_stock;
    private int product_brandID;
    private int product_supplierID;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public int getCount_in_stock() {
        return count_in_stock;
    }

    public void setCount_in_stock(int count_in_stock) {
        this.count_in_stock = count_in_stock;
    }

    public int getProduct_brandID() {
        return product_brandID;
    }

    public void setProduct_brandID(int product_brandID) {
        this.product_brandID = product_brandID;
    }

    public int getProduct_supplierID() {
        return product_supplierID;
    }

    public void setProduct_supplierID(int product_supplierID) {
        this.product_supplierID = product_supplierID;
    }
}
