package com.java.user;

import java.util.Scanner;

import com.java.connectiondone.userConnect;
import com.java.examService.examinerService;
import com.java.examService.userService;
import com.java.model.user;

public class Main {
    public static void main(String args[]){
        userService us=new userService();
        examinerService es=new examinerService();
        while(true){
            System.out.println("Select an Option");
            System.out.println("1...Register");
            System.out.println("2...Complete Your Profile");
            System.out.println("3...Pay Exam fee");
            System.out.println("4...View Profile");
            System.out.println("5...Withdraw your application-");
            System.out.println("6...check Result and Ranking");
            System.out.println("7...Forgot Unique ID");
            System.out.println("8...Show list of all Eligible candidates");
            System.out.println("9...Examiner Login");
            Scanner sc=new Scanner(System.in);
            int op=sc.nextInt();
            if(op==1){
                us.addCandidate();
            }
            else if(op==2){
                us.completeProfile();
            }
            else if(op==3){
                us.payFee();
            }
            else if(op==4){
                us.viewProfile();
            }
            else if(op==5){
                us.withdrawApp();
            }
            else if(op==6){
                us.viewResult();
            }
            else if(op==7){
                us.forgotID();
            }
            else if(op==8){
                us.showCandidates();
            }
            else if(op==9){
                if(es.examinerLogin()==true){
                    System.out.println("Login Successful");
                    while(true){
                        System.out.println("Select option from- ");
                        System.out.println("1...Delete Non-eligible candidates");
                        System.out.println("2...Upload Results");
                        //System.out.println("3...Set the cut-off marks and view number of candidates Qualified");
                        //System.out.println("Drop Non-Qualified Candidates");
                        System.out.println("3...Show Rankings of Qualified candidates");
                        System.out.println("4...Log out");
                        int ch=sc.nextInt();
                        if(ch==1){
                            es.removeCandidates();
                        }
                        else if(ch==2){
                            es.uploadResults();
                        }
                        else if(ch==3){
                            es.showRanks();
                        }else if(ch==4){
                            break;
                        }
                    }
                }else{
                    System.out.println("Wrong Password");
                }
            }
        }
        //userConnect.getConnection();
        //us.addCandidate();
        //us.completeProfile();
        //us.viewProfile();
        //us.viewResult();
    }
}
