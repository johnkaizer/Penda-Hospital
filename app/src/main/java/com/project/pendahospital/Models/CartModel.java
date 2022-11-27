package com.project.pendahospital.Models;

public class CartModel {
    int id;
    String product;
    String amount;

    public CartModel(int id, String product, String amount) {
        this.id = id;
        this.product = product;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
