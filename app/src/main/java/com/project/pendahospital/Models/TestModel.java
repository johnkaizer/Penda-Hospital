package com.project.pendahospital.Models;

public class TestModel {
    String title;
    String amount;
    String patName;
    String date;
    String time;

    public TestModel() {
    }

    public TestModel(String title, String amount, String patName, String date, String time) {
        this.title = title;
        this.amount = amount;
        this.patName = patName;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
