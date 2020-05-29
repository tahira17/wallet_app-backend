package com.eadlab.wallet_app.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseEntityExcepHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler
    public final ResponseEntity<?> handlewalletexception(WalletException ex, WebRequest webRequest){

    WalletExceptionResponse resp=new WalletExceptionResponse(ex.getMessage());
    return new ResponseEntity<WalletExceptionResponse>(resp, HttpStatus.BAD_REQUEST);
}

}
