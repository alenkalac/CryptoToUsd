package com.crypto.Crypto.Api;

import com.crypto.Crypto.Factory.CryptoCurrencyFactory;
import com.crypto.Crypto.Abstract.CryptoAbstract;
import com.crypto.Crypto.Model.CryptoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/crypto", produces = "application/json")
public class UsdConvertController {

    @Autowired
    private CryptoCurrencyFactory cryptoCurrencyFactory;

    @GetMapping(path = "/{currency}/usd")
    public ResponseEntity<CryptoModel> ToUsd(@PathVariable(value = "currency") String currency) {
        try {
            CryptoAbstract currentCrypto = cryptoCurrencyFactory.getCrypto(currency);

            return ResponseEntity.status(HttpStatus.OK).body(currentCrypto.getCryptoInfo());
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}