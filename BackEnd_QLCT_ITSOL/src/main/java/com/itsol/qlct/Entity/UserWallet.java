package com.itsol.qlct.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table

public class UserWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userWalletId;
    private int role;

    @ManyToOne
    @JoinColumn
    private Wallet wallet;

    @ManyToOne
    @JoinColumn
    private Users users;

    public int getUserWalletId() {
        return userWalletId;
    }

    public void setUserWalletId(int userWalletId) {
        this.userWalletId = userWalletId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
