package com.crypto.Crypto.Services;

import com.crypto.Crypto.Currency.Currency;
import com.crypto.Crypto.Currency.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class CryptoPriceUpdater {

    private List<Currency> cryptos;

    @Autowired
    CryptoPriceUpdater(BitCoin bitcoin, LiteCoin litecoin, Ethereum ethereum, BasicAttentionToken basicAttentionToken) {
        this.cryptos = new LinkedList<>();
        cryptos.add(bitcoin);
        cryptos.add(litecoin);
        cryptos.add(ethereum);
        cryptos.add(basicAttentionToken);
    }

    @PostConstruct
    @Scheduled(fixedRate = 15000)
    public void update() throws Exception {
        cryptos.forEach(cryptoCurrency -> {
            try {
                cryptoCurrency.getCryptoInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
