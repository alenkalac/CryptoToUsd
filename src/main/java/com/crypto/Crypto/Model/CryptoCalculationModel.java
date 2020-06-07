package com.crypto.Crypto.Model;

import java.text.DecimalFormat;

public class CryptoCalculationModel {
    private double Amount;

    public CryptoCalculationModel(double amount, double crypto){
        DecimalFormat decimalFormat = new DecimalFormat("#.########");

        setAmount(Double.parseDouble(decimalFormat.format(amount / crypto)));
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}
