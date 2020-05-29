package com.eadlab.wallet_app.Exception;

import com.eadlab.wallet_app.Entity.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WalletException extends RuntimeException{

    public WalletException(String message){
        super(message);
    }
}
