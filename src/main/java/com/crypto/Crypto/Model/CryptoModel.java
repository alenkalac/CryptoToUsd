package com.crypto.Crypto.Model;

public class CryptoModel {
    private double price;

    private MarginModel margin;

    public CryptoModel(double price, MarginModel margin) {
        this.price = price;
        this.margin = margin;
    }
}