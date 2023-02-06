package com.java.model;

public class user {
    int uniqueID;
    String email;
    Long Phoneno;
    String Address;
    Double result;
    String name;
    int fee;
    public int getFee() {
        return fee;
    }
    public void setFee(int i) {
        this.fee = i;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getUniqueID() {
        return uniqueID;
    }
    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getPhoneno() {
        return Phoneno;
    }
    public void setPhoneno(Long phoneno) {
        Phoneno = phoneno;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public Double getResult() {
        return result;
    }
    public void setResult(Double result) {
        this.result = result;
    }
    public String toString(){
        return (name+"   "+email+"   "+fee);
    }
    public String showDetail(){
        return ("Unique ID-"+uniqueID+"\n"+"Name-"+name+"\n"+"Email-"+email+"\n"+"Address-"+Address+"\n"+"Phone Number-"+Phoneno+"\n"+"Exam Fee-"+fee);
    }
}
