package com.crypto.Crypto.Factory;

import com.crypto.Crypto.Currency.Bitcoin;
import com.crypto.Crypto.Currency.Ethereum;
import com.crypto.Crypto.Currency.Litecoin;
import com.crypto.Crypto.Abstract.CryptoAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CryptoCurrencyFactory {

    @Autowired
    private Bitcoin bitcoin;

    @Autowired
    private Litecoin litecoin;

    @Autowired
    private Ethereum ethereum;

    public CryptoAbstract getCrypto(String currency) throws Exception {
        switch (currency.toLowerCase()) {
            case "btc":
                return bitcoin;
            case "ltc":
                return litecoin;
            case "eth":
                return ethereum;
            default:
                throw new Exception("Currency not supported.");
        }
    }
}
