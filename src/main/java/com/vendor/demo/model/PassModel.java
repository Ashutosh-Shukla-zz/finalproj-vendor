package com.vendor.demo.model;

import java.util.Date;

public class PassModel {

    private String pass_id;

    private String pass_city;

    private int pass_length;

    private Date pass_expiryDate;

    private String vendor_id;

    private String customer_id;


    public PassModel(String pass_id, String pass_city, int pass_length, Date pass_expiryDate, String vendor_id, String customer_id) {
        this.pass_id = pass_id;
        this.pass_city = pass_city;
        this.pass_length = pass_length;
        this.pass_expiryDate = pass_expiryDate;
        this.vendor_id = vendor_id;
        this.customer_id = customer_id;
    }

    public String getPass_id() {
        return pass_id;
    }

    public void setPass_id(String pass_id) {
        this.pass_id = pass_id;
    }

    public String getPass_city() {
        return pass_city;
    }

    public void setPass_city(String pass_city) {
        this.pass_city = pass_city;
    }

    public int getPass_length() {
        return pass_length;
    }

    public void setPass_length(int pass_length) {
        this.pass_length = pass_length;
    }

    public Date getPass_expiryDate() {
        return pass_expiryDate;
    }

    public void setPass_expiryDate(Date pass_expiryDate) {
        this.pass_expiryDate = pass_expiryDate;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
}
