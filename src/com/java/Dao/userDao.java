package com.java.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.connectiondone.userConnect;
import com.java.model.user;
import com.mysql.cj.protocol.Resultset;

public class userDao {
    Connection con;
    PreparedStatement stat;
    Boolean v;
    public userDao(){
        con=userConnect.getConnection();
        v=false;
    }

    public boolean validateUID(int uid){
        try{
            stat=con.prepareStatement("select uniqueID from candidates");
            ResultSet rs=stat.executeQuery();
            while(rs.next()){
                if(rs.getInt(1)==uid){
                    v=true;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return v;
    }
    public void getUniqueID(String name,String email){
        try{
            stat=con.prepareStatement("select uniqueID from candidates where name=? and email=?");
            stat.setString(1, name);
            stat.setString(2, email);
            ResultSet rs=stat.executeQuery();
            while(rs.next()){
                System.out.println("Your Unique ID is- "+rs.getInt(1));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void insertCandidate(user u){
        try{
            stat=con.prepareStatement("insert into candidates(name,email) values(?,?)");
            stat.setString(1,u.getName());
            stat.setString(2, u.getEmail());
            stat.executeUpdate();
            System.out.println("Your profile has been created");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void compProfile(int uid, user u){
        try{
            stat=con.prepareStatement("update candidates set PhoneNo=? where uniqueID=?");
            stat.setLong(1, u.getPhoneno());
            stat.setInt(2, uid);
            stat.executeUpdate();
            stat=con.prepareStatement("update candidates set Address=? where uniqueID=?");
            stat.setString(1, u.getAddress());
            stat.setInt(2, uid);
            stat.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<user> showProfile(int uid){
        List<user> user=new ArrayList<user>();
        try{
            stat=con.prepareStatement("select *from candidates where uniqueID=?");
            stat.setInt(1, uid);
            ResultSet rs=stat.executeQuery();
            while(rs.next()){
                user us=new user();
                us.setUniqueID(rs.getInt(1));
                us.setName(rs.getString(2));
                us.setEmail(rs.getString(3));
                us.setPhoneno(rs.getLong(4));
                us.setAddress(rs.getString(5));
                us.setFee(rs.getInt(7));
                user.add(us);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }
    public void payAmount(int uni,int f){
        try{
            if(f==500){
                stat=con.prepareStatement("update candidates set examFee=500 where uniqueID=?");
                stat.setInt(1, uni);
                stat.executeUpdate();
                System.out.println("Amount Paid");
            }
            else{
                System.out.println("Wrong Amount Entered");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteCandidate(int uid){
        try{
            stat=con.prepareStatement("delete from candidates where uniqueID=?");
            stat.setInt(1, uid);
            stat.executeUpdate();
            System.out.println("Application Deleted");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<user> getList(){
        List<user> user=new ArrayList<user>();
        try{
            stat=con.prepareStatement("select Name,email,examfee from candidates where examFee=500");
            ResultSet rs=stat.executeQuery();
            while(rs.next()){
                user us=new user();
                us.setName(rs.getString(1));
                us.setEmail(rs.getString(2));
                us.setFee(rs.getInt(3));
                user.add(us);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    public void checkResult(int uid){
        try{
            stat=con.prepareStatement("select row_number() over(order by Result desc) as num,uniqueID,name,Result from candidates");
            ResultSet rs=stat.executeQuery();
            while(rs.next()){
                if(rs.getInt(2)==uid){
                    System.out.println("Rank- "+rs.getInt(1));
                    System.out.println("Unique ID- "+rs.getInt(2));
                    System.out.println("Name- "+rs.getString(3));
                    System.out.println("Result- "+rs.getDouble(4));
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
