package com.jdlx.edumanageoa.entity.order;

/**
 * 服务项或者外卖商品数据
 */

public class   AddSIOTOCItem {

    private String name;
    private int number;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
