package com.tegabet.dropped.data_layer;

import java.io.Serializable;

/**
 * Created by sultankhan on 3/16/17.
 */
public class Product implements Serializable{

    private String title;
    private String itemImageUrl;
    private float targetPercentage;
    private double targetAmount;
    private double itemPrice;

    public Product(String title, float targetPercentage, double targetAmount, double itemPrice){
        this.title = title;
        this.targetPercentage = targetPercentage;
        this.targetAmount = targetAmount;
        this.itemPrice = itemPrice;
    }

    public String getTitle(){
        return title;
    }

    public float getTargetPercentage(){
        return targetPercentage;
    }

    public double getTargetAmount(){
        return targetAmount;
    }

    public double getItemPrice(){
        return itemPrice;
    }
}
