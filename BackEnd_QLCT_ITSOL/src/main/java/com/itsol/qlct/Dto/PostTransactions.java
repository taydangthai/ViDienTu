package com.itsol.qlct.Dto;


public class PostTransactions {

    private int transId;
    private int amount;
    private int transType;
    private String dateTime;
    private String note;
    private int userId;
    private int walletId;
    private int categoryId;

    public PostTransactions(int transId, int amount, int transType, String dateTime, String note, int userId, int walletId, int categoryId) {
        this.transId = transId;
        this.amount = amount;
        this.transType = transType;
        this.dateTime = dateTime;
        this.note = note;
        this.userId = userId;
        this.walletId = walletId;
        this.categoryId = categoryId;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
