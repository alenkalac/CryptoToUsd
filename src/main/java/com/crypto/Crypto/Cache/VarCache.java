package com.crypto.Crypto.Cache;

import com.crypto.Crypto.Model.CryptoModel;

import java.util.HashMap;

public class VarCache {

    private static HashMap<String, CryptoModel> cryptoHashMap = new HashMap<>();

    public static void put(String key, CryptoModel value) {
        cryptoHashMap.put(key, value);
    }

    public static CryptoModel getByKey(String key) {
        return cryptoHashMap.getOrDefault(key, null);
    }
}