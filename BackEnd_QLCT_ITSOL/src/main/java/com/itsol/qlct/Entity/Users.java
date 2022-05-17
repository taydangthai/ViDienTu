package com.itsol.qlct.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String userName;
    private String passWord;
    private int phoneNumber;
    private int gender;
    private String pathAva;

    @OneToMany(mappedBy = "users")
    List<UserWallet> userWallets;

    @OneToMany(mappedBy = "users")
    Set<Transactions> transactions;

    @OneToOne(mappedBy = "users")
    private PasswordResetToken passwordResetToken;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPathAva() {
        return pathAva;
    }

    public void setPathAva(String pathAva) {
        this.pathAva = pathAva;
    }

    public List<UserWallet> getUserWallets() {
        return userWallets;
    }

    public void setUserWallets(List<UserWallet> userWallets) {
        this.userWallets = userWallets;
    }

    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }

    public PasswordResetToken getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(PasswordResetToken passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }
}
