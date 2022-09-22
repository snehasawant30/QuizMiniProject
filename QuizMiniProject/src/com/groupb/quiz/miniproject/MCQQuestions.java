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
	int count;
//	int studentOption = 1;
	String option;
	Scanner scan = new Scanner(System.in);
	ConnectionTest connectionTest = new ConnectionTest();
	MCQScore mcqScore = new MCQScore();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;	
	StudentRecord record = new StudentRecord();
	
	/*getDetails() will get the parameters from the displayQuestions().
	 * This method will display the questions and the particular options for it and calculate the marks according to it by calling getScore()*/
	public String getDetails(int quesID, String question, String option1, String option2, String option3, String option4) {
		do {
			try {
				System.out.println(question);
				System.out.println("a. "+option1);
				System.out.println("b. "+option2);
				System.out.println("c. "+option3);
				System.out.println("d. "+option4);
				System.out.println("Choose option between a/b/c/d : ");
				//option = scan.next().charAt(0);	
				option = scan.nextLine();
				if(option.equals("a") || option.equals("b") || option.equals("c") || option.equals("d")) {
					count = mcqScore.getScore(option, quesID);		//calling getScore() to calculate the marks obtained by the particular student after he selects the option provided to the question 
					break;
				}
				else {
					throw new InvalidOptionException("Please enter correct option");	//throws exception if invalid option is selected
				}
			} catch (InvalidOptionException e) {
				System.err.println(e);
			}
			}while(!(option.equals("a")) || !(option.equals("b")) || !(option.equals("c")) || !(option.equals("d")));
		return option;
	}
	
	/*displayQuestions() will fetch the questions from the database.*/
	public void displayQuestions(String studentOption) {
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
					getDetails(quesID, question, option1, option2, option3, option4);   //data is fetched from the mcq table and is passed to the getDetails() for displaying questions.  
			}
			//System.out.println("Correct Answer : "+correctAnswer);
			System.out.println();
			con.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		//System.out.println("Total score obtained : "+count);
		record.setStudentMarks(count, studentOption);		//studentID and marks are passed as parameters to setStudentMarks() to update the data in database.
	}
}
