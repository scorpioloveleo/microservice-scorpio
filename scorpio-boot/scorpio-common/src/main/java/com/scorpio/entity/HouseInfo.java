package com.scorpio.entity;

public class HouseInfo {

    private Long id;
    private String city;
    private String address;
    private String address1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public HouseInfo(Long id, String city, String address, String address1) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.address1 = address1;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", address1='" + address1 + '\'' +
                '}';
    }
}
