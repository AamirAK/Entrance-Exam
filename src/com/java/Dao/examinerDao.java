package com.java.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.connectiondone.userConnect;
import com.java.model.examiner;

public class examinerDao {
    Connection con;
    PreparedStatement stat;
    boolean f;
    public examinerDao(){
        con=userConnect.getConnection();
        f=false;
    }
    public boolean validateUID(int uid){
        try{
            stat=con.prepareStatement("select uniqueID from candidates");
            ResultSet rs=stat.executeQuery();
            while(rs.next()){
                if(rs.getInt(1)==uid){
                    f=true;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return f;
    }
    public void deleteCandidates(){
        try{
            stat=con.prepareStatement("delete from candidates where examFee=0");
            stat.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void updateResult(int uid,Double result){
        try{
            stat=con.prepareStatement("update candidates set Result=? where uniqueID=?");
            stat.setDouble(1, result);
            stat.setInt(2, uid);
            stat.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void insertList(){
        try{
            stat=con.prepareStatement("insert into ranks(Ranking,uniqueID,name,Result) select row_number() over(order by Result desc) as num,uniqueID,name,Result from candidates");
            stat.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    public List<examiner> displayRankings(){
        List<examiner> examiner=new ArrayList<examiner>();
        try{
            stat=con.prepareStatement("select *from ranks");
            ResultSet rs=stat.executeQuery();
            while(rs.next()){
                examiner ex=new examiner();
                ex.setRank(rs.getInt(1));
                ex.setUniqueid(rs.getInt(2));
                ex.setName(rs.getString(3));
                ex.setResult(rs.getDouble(4));
                examiner.add(ex);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return examiner;
    }

}
