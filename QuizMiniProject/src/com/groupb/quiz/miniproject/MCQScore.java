package com.groupb.quiz.miniproject;

public class MCQScore {
	int count = 0;
	public int getScore(char option, int quesID){
			if(option == 'a' || option == 'b' || option == 'c' || option == 'd') {
				//System.out.println("hi 4");
				if(quesID == 1 && option == 'a') {
					System.out.println("hi 5");
					count++;
				}
				else if(quesID == 2 && option == 'b') {
					count++;
				}
				else if(quesID == 3 && option == 'd') {
					count++;
				}
				else if(quesID == 4 && option == 'a') {
					count++;
				}
				else if(quesID == 5 && option == 'c') {
					count++;
				}
				else if(quesID == 6 && option == 'd') {
					count++;
				}	
			}
			return count;
	}
}
