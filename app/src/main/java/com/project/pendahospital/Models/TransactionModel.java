package com.project.pendahospital.Models;

public class TransactionModel {
    String TransactionDate;
    String TransactionTitle;
    String TransactionAmount;
    String CustomerPhone;
    String Location;
    String CustomerName;

    public TransactionModel() {
    }

    public TransactionModel(String transactionDate, String transactionTitle, String transactionAmount, String customerPhone, String location, String customerName) {
        TransactionDate = transactionDate;
        TransactionTitle = transactionTitle;
        TransactionAmount = transactionAmount;
        CustomerPhone = customerPhone;
        Location = location;
        CustomerName = customerName;
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

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
}
