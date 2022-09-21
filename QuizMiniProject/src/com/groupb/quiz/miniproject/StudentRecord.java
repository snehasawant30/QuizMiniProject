
package com.groupb.quiz.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentRecord {
	Connection con =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ConnectionTest connectionTest = new ConnectionTest();
	String grade;
	int count;
	String fetchOption;
	QuizImpl quizImpl = new QuizImpl();
	Scanner scan = new Scanner(System.in);
	//int studentOption = 4;
	public String calculateGrade(int count) {
		if(count > 8 && count <=10) {
			grade = "A";
		}
		else if(count >=6  && count <=8) {
			grade = "B";
		}
		else if(count == 5) {
			grade = "C";
		}
		else if(count <5) {
			grade = "fail";
		}
		return grade;
	}
	
	public String getStudentRecord(String studentOption) {
		try {
			
			do {
				con = connectionTest.getConnectionDetails();
				//select query
				String sql = "SELECT * FROM student where studentid=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, studentOption);
				rs=ps.executeQuery();
				System.out.println("Do you wish to see your record (yes/no)?" );
				fetchOption = scan.nextLine();
				try {
					if(fetchOption.equals("yes") || fetchOption.equals("no")) {
						if(fetchOption.equals("yes")) {
								System.out.println("StudentID\tName\t\tScore\tGrade");
								while(rs.next()) {
									System.out.println(+rs.getInt(1)+"\t\t"+rs.getString(2)+"		"+rs.getInt(3)+"	"+rs.getString(4));
								}
								System.out.println("Thank You. Have a Nice Day");
								//System.exit(i);
								break;
						}
						else if (fetchOption.equals("no")){
							System.out.println("\nThank You. Have a Nice Day\n");
							break;	
						}
					
					}
					else 
						throw new InvalidOptionException("Please enter value as yes/no ");	
				}
				catch(InvalidOptionException e) {
					System.err.println(e);
				}
				
				}while(!(fetchOption.equals("yes")) || !(fetchOption.equals("no")));
		
		} catch(Exception e) {
			System.err.println(e);
		}
			return fetchOption;
	}
	
	public void setStudentMarks(int count, String studentOption) {
		String grade = calculateGrade(count);
		try {
			con = connectionTest.getConnectionDetails();
			//select query
			ps = con.prepareStatement("UPDATE student SET score = ?, grade = ? WHERE studentId = ?;");
			ps.setInt(1, count);
			ps.setString(2, grade);
			ps.setString(3, studentOption);
			int i = ps.executeUpdate();
			System.out.println("Record inserted successfully"+i);
			
//			System.out.println("Do you want to view your score? Press yes/no");
			con.close();
			ps.close();
			fetchOption=getStudentRecord(studentOption);
			do { 
				if(!(fetchOption.equals("yes")) || !(fetchOption.equals("no"))) {
					System.out.println("HIIIIII");
					fetchOption = getStudentRecord(studentOption);
					System.exit(i);
				}
				else
					System.exit(i);
					//break;
			}while((fetchOption.equals("yes")) || (fetchOption.equals("no")));
			System.exit(i);
		}catch(Exception e) {
			System.err.println(e);
		}
	}	
}
