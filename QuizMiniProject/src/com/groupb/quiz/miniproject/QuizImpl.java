package com.groupb.quiz.miniproject;
//Main Class

public class QuizImpl {
	
	public static void main(String[] args) {
		
		AdminStudent adminStudent = new AdminStudent();
		
		String chooseOption = adminStudent.getUserOption();    //call method to get two options between admin and student
		do { 
			System.out.println("Choose Option === "+chooseOption);
			if(chooseOption.equals("1") || chooseOption.equals("2")) {
				break;
			}
			else
				chooseOption = adminStudent.getUserOption();	////call method to get two options between admin and student
		}while(!(chooseOption.equals("1"))|| !(chooseOption.equals("2")));
	}
}
