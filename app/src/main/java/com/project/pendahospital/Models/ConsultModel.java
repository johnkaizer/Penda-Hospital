package com.project.pendahospital.Models;

public class ConsultModel {
    String ImageUrl;
    String DoctorName;
    String DocNumber;
    String DoctorPhone;
    String DoctorCategory;
    String DoctorTime;


    public ConsultModel() {
    }

    public ConsultModel(String imageUrl, String doctorName, String docNumber, String doctorPhone, String doctorCategory, String doctorTime) {
        ImageUrl = imageUrl;
        DoctorName = doctorName;
        DocNumber = docNumber;
        DoctorPhone = doctorPhone;
        DoctorCategory = doctorCategory;
        DoctorTime = doctorTime;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getDocNumber() {
        return DocNumber;
    }

    public void setDocNumber(String docNumber) {
        DocNumber = docNumber;
    }

    public String getDoctorPhone() {
        return DoctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        DoctorPhone = doctorPhone;
    }

    public String getDoctorCategory() {
        return DoctorCategory;
    }

    public void setDoctorCategory(String doctorCategory) {
        DoctorCategory = doctorCategory;
    }

    public String getDoctorTime() {
        return DoctorTime;
    }

    public void setDoctorTime(String doctorTime) {
        DoctorTime = doctorTime;
    }
}
