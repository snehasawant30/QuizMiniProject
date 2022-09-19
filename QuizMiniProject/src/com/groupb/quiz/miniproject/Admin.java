package com.groupb.quiz.miniproject;

import java.util.Scanner;

public class Admin {
String  studentOption;
MCQQuestions question = new MCQQuestions();
Scanner scan = new Scanner( System.in) ;

public String getStudentOption() {
	try {
		do {
			System.out.println("Please enter Student ID: \n1. Sneha \n2. Nitu \n3. Abhi  \n4. Sandip \n5. Praveen ");
			studentOption =scan.next();
			
			if (studentOption.equals("1") || studentOption.equals("2") || studentOption.equals("3") || studentOption.equals("4") || studentOption.equals("5")) {
				question.displayQuestions(studentOption);
				break;
			}else {
				throw new  StudentNotFoundException ("Please enter appropriate option between 1/2/3/4/5 ");
			}  
		}while ( !(studentOption.equals("1")) || !(studentOption.equals("2")) || !(studentOption.equals("3")) || !(studentOption.equals("4")) ||!(studentOption.equals("5"))) ;
		            
		
	} catch ( StudentNotFoundException e) {
		 System.err.println(e);
	}
	return studentOption;
}
}
