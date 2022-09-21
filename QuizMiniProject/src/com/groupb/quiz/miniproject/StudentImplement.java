package com.groupb.quiz.miniproject;
//Class for fetching student data from student table
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentImplement {

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	/*fetchStudentData() is used to fetch student details from the student table based on the score obtained by them in ascending order.*/
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
			con.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	
