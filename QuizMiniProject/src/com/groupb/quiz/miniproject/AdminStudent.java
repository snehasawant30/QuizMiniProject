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
	
	/*getUserOption() is used to provide the user with two options of 1.Admin and 2. Student. 
	 * User should provide input by selecting either 1 or 2. else it will give exception*/
	public String getUserOption() {
		try {
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
					studentOption=admin.getStudentOption();				//call method for displaying names of the Students
					do { 
						if(studentOption.equals("1") || studentOption.equals("2") || studentOption.equals("3") || studentOption.equals("4") || studentOption.equals("5")) {
							break;
						}
						else
							studentOption=admin.getStudentOption();
					}while(!(studentOption.equals("1")) || !(studentOption.equals("2")) || !(studentOption.equals("3")) || !(studentOption.equals("4")) ||!(studentOption.equals("5")));
				}
				else {
					throw new InvalidOptionException("Please enter appropriate option between 1 and 2");		//throws exception if invalid option is selected
				}
		} catch(InvalidOptionException e) {
			System.err.println(e);
			}
		return chooseOption;
		
	}
	
	/*displayAdminOptions() method will display options for the admin. 
	 * admin can view the whole student database in ascending order according to the score received by the students.*/
	public String displayAdminOptions() {
		try {
//			do {
				System.out.println("Welcome Admin");
				System.out.println("Please enter a option: \n1. View Students data \n2. Return to Main Menu ");
				adminOption = scan.next();
				if(adminOption.equals("1")) {
					studentImplement.fetchStudentdata();
					do { 
					//	System.out.println("admin option==="+adminOption);
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
					throw new InvalidOptionException("Please enter appropriate option between 1 and 2");     //throws exception if invalid option is selected
					
				}
//			}while(!(adminOption.equals("1"))|| !(adminOption.equals("2")));
		}
		catch (InvalidOptionException e) {
			System.err.println(e);
		}
		return adminOption;
	}
}
