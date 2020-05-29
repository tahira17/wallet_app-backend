package com.eadlab.wallet_app.Controller;


import com.eadlab.wallet_app.Entity.Wallet;
import com.eadlab.wallet_app.Service.ValidationErrorService;
import com.eadlab.wallet_app.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/wallet")
@CrossOrigin
public class WalletController {

    @Autowired
    private WalletService walletService;
    @Autowired
    private ValidationErrorService validationErrorService;

    @GetMapping
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<>(walletService.getAll(),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getbyId(@PathVariable Long id){
        return new ResponseEntity<>(walletService.getById(id),HttpStatus.OK);

    }

    @PostMapping
  public ResponseEntity<?> create(@Valid @RequestBody Wallet wallet, BindingResult result){
        ResponseEntity errors= validationErrorService.validate(result);
        if(errors != null) return errors;
        Wallet walletsaved=walletService.createorupdate(wallet);
 return new ResponseEntity<Wallet>(walletsaved,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        walletService.delete(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

@PutMapping("/{id}")
public ResponseEntity<?> Update(@PathVariable Long id,@Valid @RequestBody Wallet wallet, BindingResult result){
    ResponseEntity errors= validationErrorService.validate(result);
    if(errors != null) return errors;
    wallet.setId(id);
    Wallet walletsaved=walletService.createorupdate(wallet);
    return new ResponseEntity<Wallet>(walletsaved,HttpStatus.OK);
}

}
