package com.itsol.qlct.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table

public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transId;
    private int amount;
    private int transType;
    private String dateTime;
    private String note;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Users users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Wallet wallet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTransType() {
        return transType;
    }

    public void setTransType(int transType) {
        this.transType = transType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
