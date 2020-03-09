package com.example.test;

public class mid {
    public  String name;
    public  String mid;

    @Override
    public String toString() {
        return "mid{" +
                "name='" + name + '\'' +
                ", mid='" + mid + '\'' +
                '}';
    }

    public mid(String name, String mid) {
        this.name = name;
        this.mid = mid;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }


}