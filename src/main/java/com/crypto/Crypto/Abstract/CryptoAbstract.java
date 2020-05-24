package com.crypto.Crypto.Abstract;

import com.crypto.Crypto.Cache.VarCache;
import com.crypto.Crypto.Model.CryptoModel;
import com.crypto.Crypto.Services.CryptoMarginService;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public abstract class CryptoAbstract {

    public abstract String getKey();

    public abstract double getUsdValue();

    public abstract CryptoMarginService getCryptoMarginService();

    public CryptoModel getCryptoInfo() throws Exception {
        try {
            CryptoMarginService cryptoMarginService = this.getCryptoMarginService();

            CryptoModel cacheCryptoModel = new CryptoModel(cryptoMarginService.getUsdValue(), cryptoMarginService.getMargin());

            VarCache.put(this.getKey(), cacheCryptoModel);

            return cacheCryptoModel;
        } catch (WebClientResponseException e) {

            System.out.println("Getting value from cache.");

            CryptoModel cryptoModel = VarCache.getByKey(this.getKey());

            return cryptoModel == null ? new CryptoModel(0, null) : cryptoModel;
        }
    }
}