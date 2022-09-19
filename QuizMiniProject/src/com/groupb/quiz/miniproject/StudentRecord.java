package com.groupb.quiz.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentRecord {
	Connection con =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ConnectionTest connectionTest = new ConnectionTest();
	String grade;
	int count;
	int studentOption = 4;
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
			con.close();
			ps.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}	
}
