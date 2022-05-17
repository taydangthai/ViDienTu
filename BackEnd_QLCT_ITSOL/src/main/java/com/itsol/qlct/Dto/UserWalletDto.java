package com.itsol.qlct.Dto;

public class UserWalletDto {

    private int userWalletId;
    private int userId;
    private int walletId;
    private int role;

    public int getUserWalletId() {
        return userWalletId;
    }

    public void setUserWalletId(int userWalletId) {
        this.userWalletId = userWalletId;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
