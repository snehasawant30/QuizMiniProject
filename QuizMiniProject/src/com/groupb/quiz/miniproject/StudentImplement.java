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
				System.out.println("	"+rs.getString(2)+"		"+rs.getInt(3)+"	"+rs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	
