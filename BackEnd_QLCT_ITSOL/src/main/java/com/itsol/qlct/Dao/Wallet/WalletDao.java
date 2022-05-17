package com.itsol.qlct.Dao.Wallet;

import com.itsol.qlct.Entity.Wallet;

import java.util.List;

public interface WalletDao{

    List<Wallet> listWallet();

    List<Wallet> searchByName(String walletName);
//    List<Wallet>
    void addWallet(Wallet wallet);
    //check
    Wallet checkWalletName(String walletName);

    void deleteWallet(int walletId);                //ok
    void updateWallet(Wallet wallet);               //ok

    //tim id tra ve ten cua bang wallet
    String findByWalletIdReturnWalletName(int walletId);

    List<Wallet> listNameAndId();

    // lay danh sach theo id
    Wallet findWalletId(int walletId);
}
