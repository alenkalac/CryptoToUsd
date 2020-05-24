package com.crypto.Crypto.Model;

import com.crypto.Crypto.Enum.BinanceTickerCurrencyTypes;

public class EndPoints {

    private static String baseApi = "https://api.binance.com/api/v3";

    private static String toUsdBaseApi = baseApi + "/ticker/price?symbol=";

    public static String getBaseApi() {
        return baseApi;
    }

    public static String getToUsdApi(BinanceTickerCurrencyTypes currencyType) {
        return toUsdBaseApi + currencyType;
    }
}