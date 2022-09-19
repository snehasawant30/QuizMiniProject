package com.groupb.quiz.miniproject;

import java.util.Scanner;

public class AdminStudent {
	String chooseOption;
	Scanner scan = new Scanner(System.in);
	MCQQuestions question = new MCQQuestions();
	
	public String getUserOption() {
		try {
			do {
				System.out.println("Please enter a option: \n1. Admin\n2. Student ");
				chooseOption = scan.nextLine();
				if(chooseOption.equals("1") || chooseOption.equals("2")) {
					question.displayQuestions();
					break;
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
}
