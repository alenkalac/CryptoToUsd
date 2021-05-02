package com.crypto.Crypto.Currency;

import com.crypto.Crypto.Cache.PriceCache;
import com.crypto.Crypto.Model.CryptoPriceModel;
import com.crypto.Crypto.Services.BinanceService;
import com.crypto.Crypto.Services.CryptoMarginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public abstract class Currency {

    @Autowired
    private BinanceService binanceService;

    public abstract String getSymbol();

    public abstract double getUsdValue();

    public abstract CryptoMarginService getCryptoMarginService();

    public BinanceService getBinanceService(){
        return this.binanceService;
    }

    public CryptoPriceModel getCryptoInfo() throws Exception {
        try {
            CryptoMarginService cryptoMarginService = this.getCryptoMarginService();

            CryptoPriceModel cacheCryptoModel = new CryptoPriceModel(cryptoMarginService.getUsdValue(), cryptoMarginService.getMargin());

            PriceCache.put(this.getSymbol(), cacheCryptoModel);

            return cacheCryptoModel;
        } catch (WebClientResponseException e) {
            CryptoPriceModel cryptoModel = PriceCache.getByKey(this.getSymbol());

            return cryptoModel == null ? new CryptoPriceModel(0, null) : cryptoModel;
        }
    }
}