package com.crypto.Crypto.Abstract;

import com.crypto.Crypto.Cache.PriceCache;
import com.crypto.Crypto.Model.CryptoPriceModel;
import com.crypto.Crypto.Services.CryptoMarginService;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public abstract class CryptoCurrency {

    public abstract String getKey();

    public abstract double getUsdValue();

    public abstract CryptoMarginService getCryptoMarginService();

    public CryptoPriceModel getCryptoInfo() throws Exception {
        try {
            CryptoMarginService cryptoMarginService = this.getCryptoMarginService();

            CryptoPriceModel cacheCryptoModel = new CryptoPriceModel(cryptoMarginService.getUsdValue(), cryptoMarginService.getMargin());

            PriceCache.put(this.getKey(), cacheCryptoModel);

            return cacheCryptoModel;
        } catch (WebClientResponseException e) {
            CryptoPriceModel cryptoModel = PriceCache.getByKey(this.getKey());

            return cryptoModel == null ? new CryptoPriceModel(0, null) : cryptoModel;
        }
    }
}