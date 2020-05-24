package com.crypto.Crypto.Currency;

import com.crypto.Crypto.Abstract.CryptoAbstract;
import com.crypto.Crypto.Enum.BinanceTickerCurrencyTypes;
import com.crypto.Crypto.Model.BinanceJsonResponseModel;
import com.crypto.Crypto.Model.EndPoints;
import com.crypto.Crypto.Services.CryptoMarginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class Litecoin extends CryptoAbstract {

    private WebClient.Builder webClientBuilder = WebClient.builder();

    @Value("${ltc.margin.type}")
    private String marginType;

    @Value("${btc.margin.value}")
    private Integer marginValue;

    public String getKey() {
        return "ltc";
    }

    public CryptoMarginService getCryptoMarginService() {
        return new CryptoMarginService(this.marginType, this.marginValue, this.getUsdValue());
    }

    public double getUsdValue() {
        BinanceJsonResponseModel binanceJsonResponseModel = webClientBuilder.build()
                .get()
                .uri(EndPoints.getToUsdApi(BinanceTickerCurrencyTypes.LTCUSDT))
                .retrieve()
                .bodyToMono(BinanceJsonResponseModel.class)
                .block();

        return binanceJsonResponseModel.getPrice();
    }
}
