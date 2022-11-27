package com.project.pendahospital;

public class TransactionModel {
    String TransactionDate;
    String TransactionTitle;
    String TransactionAmount;
    String Product;
    String CustomerPhone;
    String Location;

    public TransactionModel() {
    }

    public TransactionModel(String transactionDate, String transactionTitle, String transactionAmount, String product, String customerPhone, String location) {
        TransactionDate = transactionDate;
        TransactionTitle = transactionTitle;
        TransactionAmount = transactionAmount;
        Product = product;
        CustomerPhone = customerPhone;
        Location = location;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getTransactionTitle() {
        return TransactionTitle;
    }

    public void setTransactionTitle(String transactionTitle) {
        TransactionTitle = transactionTitle;
    }

    public String getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        TransactionAmount = transactionAmount;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
