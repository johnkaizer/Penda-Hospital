package com.project.pendahospital;

public class ConsultModel {
    String DoctorName;
    String DoctorTime;
    String DoctorPhone;

    public ConsultModel() {
    }

    public ConsultModel(String doctorName, String doctorTime, String doctorPhone) {
        DoctorName = doctorName;
        DoctorTime = doctorTime;
        DoctorPhone = doctorPhone;
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
}
