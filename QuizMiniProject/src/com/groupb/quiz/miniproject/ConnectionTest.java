package com.groupb.quiz.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	Connection con=null;
	public Connection getConnectionDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Nitu@654321");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
