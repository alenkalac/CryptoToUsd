package com.crypto.Crypto.Currency;

import com.crypto.Crypto.Model.Binance.CryptoPrice;
import com.crypto.Crypto.Model.Binance.BinanceTickerCurrency;
import com.crypto.Crypto.Services.CryptoMarginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BitCoin extends Currency {

    @Value("${btc.margin.type}")
    private String marginType;

    @Value("${btc.margin.value}")
    private double marginValue;

    public String getSymbol() {
        return "btc";
    }

    public CryptoMarginService getCryptoMarginService() {
        return new CryptoMarginService(this.marginType, this.marginValue, this.getUsdValue());
    }

    public double getUsdValue() {
        CryptoPrice cryptoPrice = this.getBinanceService().getCryptoPrice(BinanceTickerCurrency.BTCUSDT);
        return cryptoPrice.getPrice();
    }
}