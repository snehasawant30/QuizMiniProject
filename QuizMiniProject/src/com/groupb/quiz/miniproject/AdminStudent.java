package com.groupb.quiz.miniproject;
//Class for displaying admin and student options
import java.util.Scanner;

public class AdminStudent {
	String chooseOption;
	String adminOption;
	String studentOption;
	Scanner scan = new Scanner(System.in);
	Admin admin = new Admin();
	StudentImplement studentImplement = new StudentImplement();
	QuizImpl quizImpl = new QuizImpl();
	
	public String getUserOption() {
		try {
			do {
				System.out.println("Please enter a option between 1 and 2: \n1. Admin\n2. Student ");
				chooseOption = scan.nextLine();
		
				if(chooseOption.equals("1")) {
					adminOption=displayAdminOptions();                     //call method for displaying options for Admin
					do { 
						if(adminOption.equals("1")) {
							break;
						}
						else
							adminOption = displayAdminOptions();		//call method for displaying options for Admin
					}while(!(adminOption.equals("1")));
				}
				
				else if(chooseOption.equals("2")) {
					studentOption=admin.getStudentOption();				//call method for displaying options for Student
					do { 
						//System.out.println("HI Adminstudent user option");
						if(studentOption.equals("1") || studentOption.equals("2") || studentOption.equals("3") || studentOption.equals("4") || studentOption.equals("5")) {
							break;
						}
						else
							studentOption=admin.getStudentOption();
					}while(!(studentOption.equals("1")) || !(studentOption.equals("2")) || !(studentOption.equals("3")) || !(studentOption.equals("4")) ||!(studentOption.equals("5")));
				}
				else {
					throw new InvalidOptionException("Please enter appropriate option between 1 and 2");
				}
			}while(!(chooseOption.equals("1"))|| !(chooseOption.equals("2")));
		} catch(InvalidOptionException e) {
			System.err.println(e);
			}
		return chooseOption;
		
	}
	public String displayAdminOptions() {
		try {
			do {
				System.out.println("Welcome Admin");
				System.out.println("Please enter a option: \n1. View Students data \n2. Return to Main Menu ");
				adminOption = scan.next();
				if(adminOption.equals("1")) {
					studentImplement.fetchStudentdata();
					do { 
						if(adminOption.equals("1")) {
							break;
						}
						else
							studentImplement.fetchStudentdata();
					}while(!(adminOption.equals("1")));
					System.out.println("Thank You");
				}
				else if(adminOption.equals("2")) {
					quizImpl.main(null);
				//	break;
					do { 
						if(adminOption.equals("2")) {
							break;
						}
						else
							quizImpl.main(null);
					}while(!(adminOption.equals("2")));
				}
				else {
					throw new InvalidOptionException("Please enter appropriate option between 1 and 2");
					
				}
			}while(!(adminOption.equals("1"))|| !(adminOption.equals("2")));
		}
		catch (InvalidOptionException e) {
			System.err.println(e);
		}
		return adminOption;
	}
}
