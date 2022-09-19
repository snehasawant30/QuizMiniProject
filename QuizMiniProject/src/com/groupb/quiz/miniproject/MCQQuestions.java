package com.groupb.quiz.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MCQQuestions {
	
	int quesID;
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	String correctAnswer;
	int count=0;
	char option;
	
	Scanner scan = new Scanner(System.in);
	ConnectionTest connectionTest = new ConnectionTest();
	MCQScore mcqScore = new MCQScore();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public char getDetails(int quesID, String question, String option1, String option2, String option3, String option4, String correctAnswer) {
		//char option = this.option;
		do {
			try {
				System.out.println(question);
				System.out.println("a. "+option1);
				System.out.println("b. "+option2);
				System.out.println("c. "+option3);
				System.out.println("d. "+option4);
				
				System.out.println("Choose option between a/b/c/d : ");
				option = scan.next().charAt(0);	
				//System.out.println("hi 1");
				if(option == 'a' || option == 'b' || option == 'c' || option == 'd') {
					//System.out.println("hi 2");
				//	System.out.println("Option = "+option);
					//System.out.println("Questionid : "+quesID);
					count = mcqScore.getScore(option, quesID);
					break;
				}
				else {
					//System.out.println("hi3");
					throw new InvalidOptionException("Please enter correct option");
				}
			} catch (InvalidOptionException e) {
				System.err.println(e);
			}
			}while(option != 'a' || option != 'b' || option != 'c' || option != 'd');

		
		return option;
	}
	
	public void displayQuestions() {
		
		try {
			con = connectionTest.getConnectionDetails();
			//select query
			ps = con.prepareStatement("select * from mcq");
			rs = ps.executeQuery();
			
			while(rs.next()) {
					question = rs.getString(2);
					option1 = rs.getString(3);
					option2 = rs.getString(4);
					option3 = rs.getString(5);
					option4 = rs.getString(6);
					quesID = rs.getInt(1);
					correctAnswer = rs.getString(7);
					getDetails(quesID, question, option1, option2, option3, option4, correctAnswer);
					//while (option != 'a' || option != 'b' || option != 'c' || option != 'd') {
						//getDetails(quesID, question, option1, option2, option3, option4, correctAnswer);
					//}
//					do {
//						System.out.println("hi");
//						getDetails(quesID, question, option1, option2, option3, option4, correctAnswer);
//					}while (option != 'a' || option != 'b' || option != 'c' || option != 'd');		
			}
			System.out.println("Correct Answer : "+correctAnswer);
			System.out.println();

			con.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Total score obtained : "+count);
	}
}
