package com.eadlab.wallet_app.Controller;


import com.eadlab.wallet_app.Entity.Transaction;
import com.eadlab.wallet_app.Entity.Wallet;
import com.eadlab.wallet_app.Service.TransactionService;
import com.eadlab.wallet_app.Service.ValidationErrorService;
import com.eadlab.wallet_app.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.java2d.loops.TransformBlit;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {


    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ValidationErrorService validationErrorService;

    @GetMapping("/{wallet_id}")
    public ResponseEntity<?> getAll(@PathVariable Long wallet_id){

        return new ResponseEntity<>(transactionService.getAll(wallet_id), HttpStatus.OK);

    }

    @GetMapping("/{wallet_id}/{id}")
    public ResponseEntity<?> getbyId(@PathVariable Long wallet_id,@PathVariable Long id){

        return new ResponseEntity<>(transactionService.getById(wallet_id,id), HttpStatus.OK);

    }

    @PostMapping("/{wallet_id}")
    public ResponseEntity<?> create(@PathVariable Long wallet_id, @Valid @RequestBody Transaction transaction, BindingResult result){
        ResponseEntity errors= validationErrorService.validate(result);
        if(errors != null) return errors;
        Transaction transactionsaved=transactionService.createorupdate(wallet_id,transaction);
        return new ResponseEntity<Transaction>(transaction,HttpStatus.CREATED);
    }


    @DeleteMapping("/{wallet_id}/{id}")
    public ResponseEntity<?> delete(@PathVariable long wallet_id,@PathVariable long id){
        transactionService.delete(wallet_id,id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{wallet_id}/{id}")
    public ResponseEntity<?> Update(@PathVariable Long wallet_id,@PathVariable Long id,@Valid @RequestBody Transaction transaction, BindingResult result){
        ResponseEntity errors= validationErrorService.validate(result);
        if(errors != null) return errors;
        transaction.setId(id);
        Transaction transactionsaved=transactionService.createorupdate(wallet_id,transaction);
        return new ResponseEntity<Transaction>(transactionsaved,HttpStatus.OK);
    }
}
