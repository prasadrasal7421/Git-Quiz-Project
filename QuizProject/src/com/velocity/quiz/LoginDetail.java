package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginDetail {

	public static void main(String[] args) {
		int correctAnsCount = 0;
		int wrongAnsCount = 0;
		
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetail",
					"root","Root");
			PreparedStatement pmt=con.prepareStatement("insert into login values(?,?)");
		
			System.out.println("-----------------------Java Quiz-----------------------");
			System.out.println("Enter user Name");
			String username=sc.next();
			System.out.println("Enter The Password");
			String password=sc.next();
			pmt.setString(1,username);
			pmt.setString(2,password);
			pmt.executeUpdate();
			
			pmt.close();
			System.out.println("Login Succesfully");
			System.out.println(" ");
			System.out.println("Walecome Students");
			System.out.println("Please read the instructions carefully");
			System.out.println("1. Read the questions carefully and choose the option");
			System.out.println("2. Choose one option below of them");
			System.out.println("3. Try to attempt all questions");
			System.out.println(" ");
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		
	}
		Questions q1=new Questions("1. Which statement is used to insert a new data in a database ?","A.Insert new","B.Insert Into","C.Add New","D.Update");
		Questions q2=new Questions("2. MYSQL is a_______?","A. Structured query language","B. DBMS","C.an operating system","D.an operating system");
		Questions q3=new Questions("3. Who invented Java Programming?","A.Bjarne Stroustrup","B.Dennis Ritchie","C.Guido van Rossum","D.James Gosling");
		Questions q4=new Questions("4. Which component is used to compile, debug and execute the java programs?","A.JRE","B.JIT","C.JDK","D.JVM");
		Questions q5=new Questions("5. Which one of the following is not a Java feature?","A.Use of pointers","B.Object-oriented","C.Portable","D.Dynamic and Extensible");
		Questions q6=new Questions("6. What is the extension of java code files?","A..js","B..Txt","C..Java","D..Class");
		Questions q7=new Questions("7. Which environment variable is used to set the java path?","A.MAVEN_Path","B.JavaPath","C.Java","D.Java_HOme");
		Questions q8=new Questions("8. Which of the following is not an OOPS concept in Java?","A.Polymorphism","B.Compilation","C.Inheritance","D.Encapsulation");
	    Questions q9=new Questions("9. Which exception is thrown when java is out of memory?","A.MemoryError","B.MemoryOutOfBoundsException","C.OutOfMemoryError","D.MemoryFullException");
		Questions q10=new Questions("10. Which of the following is a superclass of every class in Java?","A.ArrayList","B.Object class","C.Abstract class","D.String");

		
	
		Map<Questions,Character> hmap=new HashMap<>();
	//	PreparedStatement pmt2=con.prepareStatement("insert into quiz values(?,?)");
		hmap.put(q1, 'B');
		hmap.put(q2, 'A');
		hmap.put(q3, 'D');
		hmap.put(q4, 'C');
		hmap.put(q5, 'A');
		hmap.put(q6, 'C');
		hmap.put(q7, 'D');
		hmap.put(q8, 'B');
		hmap.put(q9, 'C');
		hmap.put(q10, 'B');
		
		for(Map.Entry<Questions, Character> map:hmap.entrySet()) {
			System.out.println(" ");
			System.out.println(map.getKey().getQuestion());
			System.out.println(map.getKey().getOption1());
			System.out.println(map.getKey().getOption2());
			System.out.println(map.getKey().getOption3());
			System.out.println(map.getKey().getOption4());
			
			
			System.out.println("Choose the Answer");
			Character ans=sc.next().charAt(0);
		
			int  cans=Character.compare(ans, map.getValue());
			
			if(cans==0) {
				System.out.println("Correct");
				correctAnsCount++;
			}else {
				System.out.println("Wrong");
				
				wrongAnsCount++;
			}}
		System.out.println(" ");
		System.out.println("------------Result---------------------------------");
		System.out.println("Total Questions :"+hmap.size());
		
		System.out.println("Correct Answered Questions :"+correctAnsCount);
		System.out.println("Wrong Answered Questions :"+wrongAnsCount);
		int percentage=(correctAnsCount*100)/hmap.size();
		System.out.println("Percentage :"+(correctAnsCount*100)/hmap.size());
		System.out.println(" ");
	if(percentage<35) {
	System.out.println("Grade : D");
	}else if(percentage>35 && percentage<60) {
		System.out.println("Grade : C");
	}else if(percentage>60 && percentage<90) {
		System.out.println("Grade : B");
	}else if(percentage>90) {
		System.out.println("Grade : A");
	}
		
	}
}





