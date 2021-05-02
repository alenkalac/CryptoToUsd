package com.crypto.Crypto.Model;

public class CryptoPriceModel {
    private double price;

    private Margin margin;

    public CryptoPriceModel(double price, Margin margin){
        setPrice(price);
        setMargin(margin);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double priceInUsd) {
        this.price = priceInUsd;
    }

    public Margin getMargin() {
        return margin;
    }

    public void setMargin(Margin margin) {
        this.margin = margin;
    }
}
