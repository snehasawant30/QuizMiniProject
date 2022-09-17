package com.groupb.quiz.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.print.attribute.HashAttributeSet;

public class MCQQuestions {
	
	int quesID;
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	String correctAnswer;
	int count=0;
	
	public void getScore(char option, int quesID) {
		try {
			if(quesID == 1 && option == 'a') {
				count++;
			}
			if(quesID == 2 && option == 'b') {
				count++;
			}
			if(quesID == 3 && option == 'd') {
				count++;
			}
			if(quesID == 4 && option == 'a') {
				count++;
			}
			if(quesID == 5 && option == 'c') {
				count++;
			}
			if(quesID == 6 && option == 'd') {
				count++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void displayQuestions() {
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "Sneha@30");
			
			//select query
			PreparedStatement ps = con.prepareStatement("select * from mcq");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				question = rs.getString(2);
				option1 = rs.getString(3);
				option2 = rs.getString(4);
				option3 = rs.getString(5);
				option4 = rs.getString(6);
				quesID = rs.getInt(1);
				correctAnswer = rs.getString(7);
				
				System.out.println(question);
				System.out.println("a. "+option1);
				System.out.println("b. "+option2);
				System.out.println("c. "+option3);
				System.out.println("d. "+option4);
				
				System.out.println("Choose option between a/b/c/d : ");
				char option = scan.next().charAt(0);
				
				getScore(option, quesID);
				System.out.println("Correct Answer : "+correctAnswer);
				System.out.println();
			}
			System.out.println("Total score obtained : "+count);
			con.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
