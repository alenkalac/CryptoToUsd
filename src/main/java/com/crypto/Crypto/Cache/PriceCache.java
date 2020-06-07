package com.crypto.Crypto.Cache;

import com.crypto.Crypto.Model.CryptoPriceModel;

import java.util.HashMap;

public class PriceCache {

    private static HashMap<String, CryptoPriceModel> cryptoHashMap = new HashMap<>();

    public static void put(String key, CryptoPriceModel value) {
        cryptoHashMap.put(key, value);
    }

    public static CryptoPriceModel getByKey(String key) {
        return cryptoHashMap.getOrDefault(key, null);
    }
}