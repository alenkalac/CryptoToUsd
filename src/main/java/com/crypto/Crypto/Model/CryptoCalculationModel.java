package com.crypto.Crypto.Model;

import java.text.DecimalFormat;

public class CryptoCalculationModel {
    private double amount;

    public CryptoCalculationModel(double amount, double crypto){
        this.amount = (amount / crypto);
    }

    public double getAmount() {
        return amount;
    }

    public String getFormatted() {
        DecimalFormat decimalFormat = new DecimalFormat("#.########");

        return decimalFormat.format(this.amount);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
