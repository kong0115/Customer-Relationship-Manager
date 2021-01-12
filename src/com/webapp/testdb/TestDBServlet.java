package com.webapp.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


/**
 * Servlet for testing database connection
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setup connection variables
		String user = "admin";
		String pass = "admin";
		String url = "jdbc:mysql://localhost:3306/customer-tracker";
		String driver =  "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connection to database: " + url);
			
			//load jdbc driver
			Class.forName(driver);
			
			//get connection to database
			Connection connection = DriverManager.getConnection(url, user, pass);
			out.println("Connection succesful!");
			
			connection.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
