package com.crypto.Crypto.Model;

public class CryptoModel {
    private double priceInUsd;

    private Margin margin;

    public CryptoModel(double priceInUsd, Margin margin){
        this.priceInUsd = priceInUsd;
        this.margin = margin;
    }

    public double getPriceInUsd() {
        return priceInUsd;
    }

    public void setPriceInUsd(double priceInUsd) {
        this.priceInUsd = priceInUsd;
    }

    public Margin getMargin() {
        return margin;
    }

    public void setMargin(Margin margin) {
        this.margin = margin;
    }
}
