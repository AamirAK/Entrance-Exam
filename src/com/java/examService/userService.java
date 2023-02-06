package com.java.examService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.Dao.userDao;
import com.java.model.user;

public class userService {
    private Scanner sc;
    userDao uDao;
    boolean f;
    public userService(){
        sc=new Scanner(System.in);
        uDao=new userDao();
    }
    public void addCandidate(){
        System.out.println("Enter Name and Email-");
        String nm=sc.nextLine();
        String em=sc.nextLine();
        user u=new user();
        u.setName(nm);
        u.setEmail(em);
        uDao.insertCandidate(u);
        uDao.getUniqueID(nm, em);
    }
    public void completeProfile(){
        System.out.println("Enter UniqueID-");
        int uid=sc.nextInt();
        f=uDao.validateUID(uid);
        if(f==true){
            System.out.println("Enter Phone Number-");
            Long phno=sc.nextLong();
            System.out.println("Enter Address-");
            sc.nextLine();
            String ad=sc.nextLine();
            user u=new user();
            u.setPhoneno(phno);
            u.setAddress(ad);
            uDao.compProfile(uid, u);
        }
        else{
            System.out.println("Unique ID does not exist");
        }
    }
    public void viewProfile(){
        System.out.println("Enter Unique ID-");
        int uid=sc.nextInt();
        f=uDao.validateUID(uid);
        if(f==true){
            List<user> us=new ArrayList<user>();
            us=uDao.showProfile(uid);
            for(user u:us){
                System.out.println(u.showDetail());
            }
        }
        else{
            System.out.println("Invalid Unique ID");
        }
        
    }
    public void payFee(){
        System.out.println("Enter Unique ID");
        int uid=sc.nextInt();
        f=uDao.validateUID(uid);
        if(f==true){
            System.out.println("Enter amount Rupees 500");
            int amt=sc.nextInt();
            uDao.payAmount(uid, amt);
        }
        else{
            System.out.println("Invalid Unique ID");
        }
    }
    public void viewResult(){
        System.out.println("Enter Unique ID");
        int uid=sc.nextInt();
        f=uDao.validateUID(uid);
        if(f==true){
            uDao.checkResult(uid);
        }else{
            System.out.println("Invalid Unique ID");
        }
        
    }
    // public void viewResult(){
    //     System.out.println("Enter Unique ID");
    //     int uid=sc.nextInt();
    //     f=uDao.validateUID(uid);
    //     if(f==true){
    //         uDao.showResult(uid);
    //     }else{
    //         System.out.println("Invalid Unique ID");
    //     }
        
    // }

    public void showCandidates(){
        System.out.println("List of candidates elegible for Examination:");
        System.out.println("Name  "+"   Email   "+"  ExamFee");
        List<user> us=new ArrayList<user>();
        us=uDao.getList();
        for(user u:us){
            System.out.println(u.toString());
        }
    }
    public void withdrawApp(){
        System.out.println("Enter Unique ID-");
        int uid=sc.nextInt();
        f=uDao.validateUID(uid);
        if(f==true){
            uDao.deleteCandidate(uid);
        }
        else{
            System.out.println("Invalid Unique ID");
        }
    }
    public void forgotID(){
        System.out.println("Enter Name and Email");
        String nm=sc.nextLine();
        String em=sc.nextLine();
        uDao.getUniqueID(nm,em);
    }
}
