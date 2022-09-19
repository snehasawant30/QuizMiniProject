package com.groupb.quiz.miniproject;

import java.util.Scanner;

public class Admin {
String  choosestudent;

Scanner scan = new Scanner( System.in) ;

public String getstudentoption() {
	try {
		do {
			System.out.println("please enter student name: \n1. sneha \n2. nitu \n3. abhi  \n4. sandip \n5. praveen ");
			choosestudent =scan.next();
			
			if ( choosestudent.equals( "1")|| choosestudent.equals( "2") || choosestudent.equals( "3")|| choosestudent.equals( "4") || choosestudent.equals( "5")) {
				System.out.println("hii");
				break ;
				
				
			
			}else {
				throw new  StudentNotFoundException (" please enter correct name from given option");
			}  
		}while ( ! ( choosestudent.equals( "1") )|| ! ( choosestudent.equals( "2") ) || ! ( choosestudent.equals( "3") ) || ! ( choosestudent.equals( "4") ) ||! ( choosestudent.equals( "5") )) ;
		            
		
	} catch ( StudentNotFoundException e) {
		 System.err.println(e);
	}
	return choosestudent;
}
}
