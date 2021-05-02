package com.crypto.Crypto.Controller;

import com.crypto.Crypto.Cache.PriceCache;
import com.crypto.Crypto.Model.CryptoCalculationModel;
import com.crypto.Crypto.Model.CryptoPriceModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/crypto", produces = "application/json")
public class UsdConvertController {
    
    @GetMapping(path = "/{currency}/usd")
    public ResponseEntity<CryptoPriceModel> ToUsd(@PathVariable(value = "currency") String currency) {
        return ResponseEntity.status(HttpStatus.OK).body(PriceCache.getByKey(currency));
    }

    @GetMapping(path = "/{currency}/usd/{amount}")
    public ResponseEntity<CryptoCalculationModel> CalculateAmount(@PathVariable(value = "currency") String currency, @PathVariable(value = "amount") double amount) {
        CryptoPriceModel cryptoPriceModel = PriceCache.getByKey(currency);

        CryptoCalculationModel cryptoCalculationModel = new CryptoCalculationModel(amount, cryptoPriceModel.getPrice());

        return ResponseEntity.status(HttpStatus.OK)
                .body(cryptoCalculationModel);
    }
}