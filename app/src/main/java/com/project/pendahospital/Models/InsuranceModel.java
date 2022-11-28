package com.project.pendahospital.Models;

public class InsuranceModel {
    public String patName;
    public String patNo;

    public InsuranceModel(String patName, String patNo) {
        this.patName = patName;
        this.patNo = patNo;
    }

    public InsuranceModel() {
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatNo() {
        return patNo;
    }

    public void setPatNo(String patNo) {
        this.patNo = patNo;
    }
}
