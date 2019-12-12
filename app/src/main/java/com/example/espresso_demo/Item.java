package com.example.espresso_demo;

public class Item {
    private String title, desc, quantity;

    public Item() {
    }

    public Item(String title, String desc, String quantity) {
        this.title = title;
        this.desc = desc;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}