package com.project.pendahospital.Models;

public class ProductsModel {
    String ImageUrl;
    String ProductName;
    String ProductAmount;
    String ProductDescription;

    public ProductsModel() {
    }

    public ProductsModel(String imageUrl, String productName, String productAmount, String productDescription) {
        ImageUrl = imageUrl;
        ProductName = productName;
        ProductAmount = productAmount;
        ProductDescription = productDescription;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductAmount() {
        return ProductAmount;
    }

    public void setProductAmount(String productAmount) {
        ProductAmount = productAmount;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }
}
