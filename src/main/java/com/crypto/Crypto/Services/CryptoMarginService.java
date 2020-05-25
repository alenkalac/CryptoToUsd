package com.crypto.Crypto.Services;

import com.crypto.Crypto.Model.MarginModel;

import java.text.DecimalFormat;

public class CryptoMarginService {
    private String marginType;

    private Integer marginValue;

    private double usdValue;

    public CryptoMarginService(String marginType, Integer marginValue, double usdValue) {
        this.marginType = marginType;
        this.marginValue = marginValue;
        this.usdValue = usdValue;
    }

    public MarginModel getMargin() throws Exception {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        double buyAt;
        double sellAt;

        switch (marginType.toLowerCase()) {
            case "flat":
                buyAt = Double.parseDouble(decimalFormat.format(usdValue + marginValue));
                sellAt = Double.parseDouble(decimalFormat.format(usdValue - marginValue));

                return new MarginModel(buyAt, sellAt);
            case "percentage":
                buyAt = Double.parseDouble(decimalFormat.format(usdValue + ((usdValue / 100) * marginValue)));
                sellAt = Double.parseDouble(decimalFormat.format(usdValue - ((usdValue / 100) * marginValue)));

                return new MarginModel(buyAt, sellAt);
            default:
                throw new Exception("Unsupported margin type");
        }
    }

    public double getUsdValue() {
        return this.usdValue;
    }
}
