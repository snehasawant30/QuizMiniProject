package com.groupb.quiz.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentImplement {

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public void fetchStudentdata() {
		
		try {
			ConnectionTest test=new ConnectionTest();
			con=test.getConnectionDetails();
			String sql="SELECT * from student ORDER BY Score ASC";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			System.out.println("\tName\t\tScore\tGrade");
			while(rs.next()) {
				//System.out.println("Student ID: "+rs.getInt(1));
//				System.out.println("Student Name: "+rs.getString(2));
//				System.out.println("Score: "+rs.getString(3));
//				System.out.println("Grade: "+rs.getString(4));
				System.out.println("	"+rs.getString(2)+"		"+rs.getInt(3)+"	"+rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void InsertStudentData(int Score,String Grade ) {
//		try {
//		ConnectionTest test=new ConnectionTest();
//		con=test.getConnectionDetails();
//		ps=con.prepareStatement("insert into student (Score,Grade) values(?,?)");
//		ps.setInt(2, Score);
//		ps.setString(3, Grade);
//		int i=ps.executeUpdate();
//		System.out.println("Record is inserted successfully..."+i);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//			
//	}
}
	
