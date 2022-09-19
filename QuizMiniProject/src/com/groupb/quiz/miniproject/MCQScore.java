package com.groupb.quiz.miniproject;

public class MCQScore {
	int count = 0;
	public int getScore(String option, int quesID){
			
				if(quesID == 1 && option.equals("a")) {
					count++;
				}
				else if(quesID == 2 && option.equals("b")) {
					count++;
				}
				else if(quesID == 3 && option.equals("d")) {
					count++;
				}
				else if(quesID == 4 && option.equals("a")) {
					count++;
				}
				else if(quesID == 5 && option.equals("c")) {
					count++;
				}
				else if(quesID == 6 && option.equals("d")) {
					count++;	
				}
				else if(quesID == 7 && option.equals("c")) {
					count++;
				}
				else if(quesID ==8 && option.equals("a")) {
					count++;
				}
				else if(quesID ==9 && option.equals("a")) {
					count++;
				}
				else if(quesID ==10 && option.equals("b")) {
					count++;
				}
					
			return count;
	}
}
