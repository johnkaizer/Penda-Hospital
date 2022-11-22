package com.project.pendahospital.Models;

public class AppointmentModel {
    String DocName;
    String DocCategory;
    String PatName;
    String PatPhone;
    String PatTime;
    String PatDate;

    public AppointmentModel() {
    }

    public AppointmentModel(String docName, String docCategory, String patName, String patPhone, String patTime, String patDate) {
        DocName = docName;
        DocCategory = docCategory;
        PatName = patName;
        PatPhone = patPhone;
        PatTime = patTime;
        PatDate = patDate;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        DocName = docName;
    }

    public String getDocCategory() {
        return DocCategory;
    }

    public void setDocCategory(String docCategory) {
        DocCategory = docCategory;
    }

    public String getPatName() {
        return PatName;
    }

    public void setPatName(String patName) {
        PatName = patName;
    }

    public String getPatPhone() {
        return PatPhone;
    }

    public void setPatPhone(String patPhone) {
        PatPhone = patPhone;
    }

    public String getPatTime() {
        return PatTime;
    }

    public void setPatTime(String patTime) {
        PatTime = patTime;
    }

    public String getPatDate() {
        return PatDate;
    }

    public void setPatDate(String patDate) {
        PatDate = patDate;
    }
}
