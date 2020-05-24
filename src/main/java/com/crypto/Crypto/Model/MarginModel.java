package com.crypto.Crypto.Model;

public class MarginModel
{
    public double buy;

    public double sell;

    public double getBuy() {
        return buy;
    }

    public double getSell() {
        return sell;
    }

    public MarginModel(double buy, double sell){
        this.buy = buy;
        this.sell = sell;
    }
}
