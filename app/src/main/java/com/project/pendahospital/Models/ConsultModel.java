package com.project.pendahospital.Models;

public class ConsultModel {
    String DoctorName;
    String DoctorTime;
    String DoctorPhone;
    String DoctorCategory;

    public ConsultModel() {
    }

    public ConsultModel(String doctorName, String doctorTime, String doctorPhone, String doctorCategory) {
        DoctorName = doctorName;
        DoctorTime = doctorTime;
        DoctorPhone = doctorPhone;
        DoctorCategory = doctorCategory;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getDoctorTime() {
        return DoctorTime;
    }

    public void setDoctorTime(String doctorTime) {
        DoctorTime = doctorTime;
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
}
