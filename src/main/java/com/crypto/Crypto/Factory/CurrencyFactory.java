package com.crypto.Crypto.Factory;

import com.crypto.Crypto.Currency.*;
import com.crypto.Crypto.Currency.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyFactory {

    @Autowired
    private BitCoin bitcoin;

    @Autowired
    private LiteCoin litecoin;

    @Autowired
    private Ethereum ethereum;

    @Autowired
    private BasicAttentionToken basicAttentionToken;

    public Currency getCrypto(String currency) throws Exception {
        switch (currency.toLowerCase()) {
            case "btc":
                return bitcoin;
            case "ltc":
                return litecoin;
            case "eth":
                return ethereum;
            case "bat":
                return basicAttentionToken;
            default:
                throw new Exception("Coin not supported.");
        }
    }
}
