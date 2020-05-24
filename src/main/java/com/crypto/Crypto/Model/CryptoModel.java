package com.crypto.Crypto.Model;

public class CryptoModel {
    private double price;

    private MarginModel margin;

    public CryptoModel(double price, MarginModel margin){
        this.price = price;
        this.margin = margin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double priceInUsd) {
        this.price = priceInUsd;
    }

    public MarginModel getMargin() {
        return margin;
    }

    public void setMargin(MarginModel margin) {
        this.margin = margin;
    }
}
