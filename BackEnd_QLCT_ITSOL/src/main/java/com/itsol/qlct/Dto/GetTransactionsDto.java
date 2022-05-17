package com.itsol.qlct.Dto;

public class GetTransactionsDto {
    /**
     * <item>
 *         <transId>136</transId>
 *         <amount>666777</amount>
 *         <dateTime>2020-08-26</dateTime>
 *         <note>frontend</note>
 *         <transType>3</transType>
 *         <userId>3</userId>
 *         <walletId>3</walletId>
 *         <categoryId>3</categoryId>
 *     </item>
     */
    private int transId;
    private int amount;
    private String dateTime;
    private String note;
    private int transType;

    private int userId;
    private String name;

    private int walletId;
    private String walletName;

    private int categoryId;
    private String categoryName;

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

    public int getTransType() {
        return transType;
    }

    public void setTransType(int transType) {
        this.transType = transType;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
