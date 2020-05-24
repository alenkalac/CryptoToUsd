package com.crypto.Crypto.Model;

public class CryptoModel {
    private double priceInUsd;

    private MarginModel margin;

    public CryptoModel(double priceInUsd, MarginModel margin){
        this.priceInUsd = priceInUsd;
        this.margin = margin;
    }

    public double getPriceInUsd() {
        return priceInUsd;
    }

    public void setPriceInUsd(double priceInUsd) {
        this.priceInUsd = priceInUsd;
    }

    public MarginModel getMargin() {
        return margin;
    }

    public void setMargin(MarginModel margin) {
        this.margin = margin;
    }
}
