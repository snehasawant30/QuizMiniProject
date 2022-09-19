package com.groupb.quiz.miniproject;

import java.util.Scanner;

public class AdminStudent {
	String chooseOption;
	String adminOption;
	Scanner scan = new Scanner(System.in);
	MCQQuestions question = new MCQQuestions();
	Admin admin = new Admin();
	StudentImplement studentImplement = new StudentImplement();
	QuizImpl quizImpl = new QuizImpl();
	
	public String getUserOption() {
		try {
			do {
				System.out.println("Please enter a option: \n1. Admin\n2. Student ");
				chooseOption = scan.nextLine();
				System.out.println("HI");
				if(chooseOption.equals("1")) {
					System.out.println("Hi Admin");
					displayAdminOptions();
					break;
				}
				else if(chooseOption.equals("2")) {
					admin.getStudentOption();
					//question.displayQuestions();
					break;
				}
				else {
					throw new InvalidOptionException("User Please enter appropriate option between 1 and 2");
				}
			}while(!(chooseOption.equals("1"))|| !(chooseOption.equals("2")));
		} catch(InvalidOptionException e) {
			System.err.println(e);
			}
		return chooseOption;
	}
	public void displayAdminOptions() {
		try {
			do {
				System.out.println("Please enter a option: \n1. View Students data \n2. Return to Main Menu ");
				adminOption = scan.next();
				if(adminOption.equals("1")) {
					studentImplement.fetchStudentdata();
					System.out.println("Thank You");
					break;
				}
				
				if(adminOption.equals("2")) {
					quizImpl.main(null);
					do { 
						if(adminOption.equals("2")) {
							break;
						}
						else
							quizImpl.main(null);
					}while(!(adminOption.equals("2")));
				}
				else {
					throw new InvalidOptionException("Admin Options Please enter appropriate option between 1 and 2");
				}
			}while(!(adminOption.equals("1"))|| !(adminOption.equals("2")));
		}
		catch (InvalidOptionException e) {
			System.err.println(e);
		}
	}
}
