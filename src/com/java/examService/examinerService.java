package com.java.examService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.java.model.examiner;
import com.java.Dao.examinerDao;

public class examinerService {
    private Scanner sc;
    examinerDao eDao;
    public examinerService(){
        sc=new Scanner(System.in);
        eDao=new examinerDao();
    }
    public boolean examinerLogin(){
        System.out.println("Enter Password");
        String p=sc.nextLine();
        examiner ex=new examiner();
        boolean f=ex.loginsuccess(p);    
        return f;
    }

    public void removeCandidates(){
        eDao.deleteCandidates();
        System.out.println("All Non-eligible candidates have been removed");
    }
    public void uploadResults(){
        System.out.println("Enter Unique ID of the candidate");
        int uid=sc.nextInt();
        if(eDao.validateUID(uid)==true){
            System.out.println("Enter Result of the Candidates");
            Double r=sc.nextDouble();
            eDao.updateResult(uid, r);
        }else{
            System.out.println("Invalid Unique ID");
        }
        
    }
    public void showRanks(){
        List<examiner> e=new ArrayList<examiner>();
        eDao.insertList();
        System.out.println("List of Qualified Candidates are: ");
        System.out.println("Rank  "+"UniqueID   "+"Name     "+"Result   ");
        e=eDao.displayRankings();
        for(examiner i:e){
            System.out.println(i.toString());
        }
    }
}
