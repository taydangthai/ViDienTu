package com.itsol.qlct.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table

public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int walletId;
    private String walletName;
    private int balance;
    private int currency;
    private String createDate;

    @OneToMany(mappedBy = "wallet")
    List<Transactions> transactions;

    @OneToMany(mappedBy = "wallet")
    List<UserWallet> userWallets;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public List<UserWallet> getUserWallets() {
        return userWallets;
    }

    public void setUserWallets(List<UserWallet> userWallets) {
        this.userWallets = userWallets;
    }
}
