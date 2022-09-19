package com.groupb.quiz.miniproject;

import java.util.Scanner;

public class QuizImpl {
//	int student = 2;
//	int admin = 1;

	public static void main(String[] args) {
		
		
		AdminStudent adminStudent = new AdminStudent();
		Admin admin = new Admin();
		
		String chooseOption = adminStudent.getUserOption();
		do { 
			if(chooseOption.equals("1") || chooseOption.equals("2")) {
				break;
			}
			else
				chooseOption = adminStudent.getUserOption();
		}while(!(chooseOption.equals("1"))|| !(chooseOption.equals("2")));
		
	}
}
