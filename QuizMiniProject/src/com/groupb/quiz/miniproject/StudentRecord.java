
package com.groupb.quiz.miniproject;
//class for calculating grade and marks of the student and fetching data from student table
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
	
	/*calculateGrade() will get the marks as parameter and based upon the marks the grade for the student is calculated and returned to the calling method.*/
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
	
	/*getStudentRecord() will get studentOption i.e. the id of the student who is appearing for the exam. based upon
	 * the studentID the data is fetched from the student table.*/
	public String getStudentRecord(String studentOption) {
		try {
			
			do {
				con = connectionTest.getConnectionDetails();
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
	
	/*setStudentMarks() will update the record in the student table in the database. the score and grade 
	 * of the particular student are updated based upon the studentID i.e studentOption selected by the user. */
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
			con.close();
			ps.close();
			fetchOption=getStudentRecord(studentOption);
			do { 
				if((fetchOption.equals("yes")) || (fetchOption.equals("no"))) {
					System.exit(i);
				}
				else
					fetchOption = getStudentRecord(studentOption);
					System.exit(i);
			}while(!(fetchOption.equals("yes")) || !(fetchOption.equals("no")));
			System.exit(i);
		}catch(Exception e) {
			System.err.println(e);
		}
	}	
}
