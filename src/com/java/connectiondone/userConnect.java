package com.java.connectiondone;

import java.sql.Connection;
import java.sql.DriverManager;

public class userConnect {
    private static Connection con;

    private userConnect(){
        try
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EntranceExam","root","EX4IWPI6_sql");
            //System.out.println("Connection Establisted");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    }
    public  static Connection  getConnection()
	 {
		userConnect d= new userConnect();
		
		 return(con);
	 }
}
