package com.crypto.Crypto.Services;

import com.crypto.Crypto.Model.MarginModel;

import java.text.DecimalFormat;

public class CryptoMarginService {
    private String marginType;
    private double marginValue;
    private double usdValue;

    public CryptoMarginService(String marginType, double marginValue, double usdValue) {
        this.marginType = marginType;
        this.marginValue = marginValue;
        this.usdValue = usdValue;
    }

    public MarginModel getMargin() throws Exception {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        String buyAt;
        String sellAt;

        switch (marginType.toLowerCase()) {
            case "flat":
                buyAt = decimalFormat.format(usdValue + marginValue);
                sellAt = decimalFormat.format(usdValue - marginValue);

                return new MarginModel(buyAt, sellAt);
            case "percentage":
                buyAt = decimalFormat.format(usdValue + ((usdValue / 100) * marginValue));
                sellAt = decimalFormat.format(usdValue - ((usdValue / 100) * marginValue));

                return new MarginModel(buyAt, sellAt);
            default:
                throw new Exception("Unsupported margin type");
        }
    }

    public double getUsdValue() {
        return this.usdValue;
    }
}
