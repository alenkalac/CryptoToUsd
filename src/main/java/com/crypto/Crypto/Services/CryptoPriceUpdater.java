package com.crypto.Crypto.Services;

import com.crypto.Crypto.Abstract.CryptoCurrency;
import com.crypto.Crypto.Currency.Bitcoin;
import com.crypto.Crypto.Currency.Ethereum;
import com.crypto.Crypto.Currency.Litecoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class CryptoPriceUpdater {

    private List<CryptoCurrency> cryptos;

    @Autowired
    CryptoPriceUpdater(Bitcoin bitcoin, Litecoin litecoin, Ethereum ethereum) {
        this.cryptos = new LinkedList<>();
        cryptos.add(bitcoin);
        cryptos.add(litecoin);
        cryptos.add(ethereum);
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
