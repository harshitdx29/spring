package com.paytm.domain;

import java.io.Serializable;

/**
 * Created by harshitgupta on 3/4/17.
 */
public class Product implements Serializable {
    private int id;
    private String description;
    private Double price;
    public int getId(){return this.id;}
    public void setId(int id){ this.id = id;}
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Double getPrice(){
        return this.price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + description + ";");
        buffer.append("Price: " + price);
        return buffer.toString();
    }
}
