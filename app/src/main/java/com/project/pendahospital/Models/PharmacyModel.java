package com.project.pendahospital.Models;

public class PharmacyModel {

    int image;
    String number;
    String content;

    public PharmacyModel(int image, String number, String content) {
        this.image = image;
        this.number = number;
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
