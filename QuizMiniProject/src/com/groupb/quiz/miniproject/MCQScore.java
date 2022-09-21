package com.groupb.quiz.miniproject;
//class to calculate the marks obtained by the student
public class MCQScore {
	int count = 0;
	
	/*getScore() is used to calculate the marks. question id and selected option of particular question is passsed here in parameters.
	 * based on that the method will check the condition and marks are stored in variable count. this count is returned to the calling method.*/
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
