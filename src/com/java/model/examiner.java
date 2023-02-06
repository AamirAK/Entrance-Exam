package com.java.model;

interface examinerlogin {
    String password="Examiner@123"; 
    Boolean loginsuccess(String s);
}
public class examiner implements examinerlogin{
    int Rank;
    int uniqueid;
    String name;
    Double result;
    
    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public int getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(int uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String toString(){
        return(Rank+"      "+uniqueid+"         "+name+"    "+result);
    }
    public Boolean loginsuccess(String s){
        boolean b;
        if(s.equals(examinerlogin.password)){
            b=true;
        }else{
            b=false;
        } 
        return b;     
    }
    
}
