package com.eadlab.wallet_app.Service;


import com.eadlab.wallet_app.Entity.Wallet;
import com.eadlab.wallet_app.Exception.WalletException;
import com.eadlab.wallet_app.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    public List<Wallet> getAll(){
        return walletRepository.findAllByOrderByPriority();
    }

    public Wallet getById(Long id){
        Optional<Wallet> wallet= walletRepository.findById(id);

        if(wallet.isPresent()){
            return wallet.get();
        }

        throw new WalletException("Wallet with "+id+" can not be found..!!");
    }

    public Wallet createorupdate(Wallet wallet){

      if(wallet.getId()==0){
            walletRepository.save(wallet);
        }else{
            walletRepository.save(wallet);

        }
        return wallet;
    }
    public boolean delete(Long id){
       Optional<Wallet> wallet= walletRepository.findById(id);

        if(wallet.isPresent()){
        walletRepository.delete(wallet.get());
        return true;
        }

        throw new WalletException("Wallet with "+id+" can not be found..!!");
    }
}
