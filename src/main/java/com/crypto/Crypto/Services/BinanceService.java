package com.crypto.Crypto.Services;

import com.crypto.Crypto.Model.Binance.CryptoPrice;
import com.crypto.Crypto.Model.Binance.BinanceTickerCurrency;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BinanceService {

    private WebClient.Builder webClientBuilder = WebClient.builder();

    private static final String baseEndPoint = "https://api.binance.com/api/v3";

    public CryptoPrice getCryptoPrice(BinanceTickerCurrency binanceTickerCurrency){

        final String toUsdQuery = baseEndPoint + "/ticker/price?symbol=" + binanceTickerCurrency;

        return webClientBuilder.build()
                .get()
                .uri(toUsdQuery)
                .retrieve()
                .bodyToMono(CryptoPrice.class)
                .block();
    }
}
