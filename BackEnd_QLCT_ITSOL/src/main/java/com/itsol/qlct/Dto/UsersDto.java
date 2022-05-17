package com.itsol.qlct.Dto;

public class UsersDto {

    private int userId;
    private String name;
    private String userName;
    private String passWord;
    private int phoneNumber;
    private int gender;
    private String pathAva;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
