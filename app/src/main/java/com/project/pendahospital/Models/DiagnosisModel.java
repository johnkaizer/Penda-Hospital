package com.project.pendahospital.Models;

public class DiagnosisModel {
    int image;
    String disease;
    String description;
    String amount;

    public DiagnosisModel(int image, String disease, String description, String amount) {
        this.image = image;
        this.disease = disease;
        this.description = description;
        this.amount = amount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
