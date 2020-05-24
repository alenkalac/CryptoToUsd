package com.crypto.Crypto.Model;

public class Margin
{
    public double buy;

    public double sell;

    public double getBuy() {
        return buy;
    }

    public double getSell() {
        return sell;
    }

    public Margin(double buy, double sell){
        this.buy = buy;
        this.sell = sell;
    }
}
