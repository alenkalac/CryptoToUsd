package com.crypto.Crypto.Model;

public class CryptoPriceModel {
    private double price;

    private MarginModel margin;

    public CryptoPriceModel(double price, MarginModel margin){
        setPrice(price);
        setMargin(margin);
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
