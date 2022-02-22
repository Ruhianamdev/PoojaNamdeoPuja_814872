
package com.ruhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ConnectionDB conn;
	@Override
	public void init() throws ServletException {
		try {
			conn = new ConnectionDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy(){
		try {
			conn.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//out.print("insert into user values('" + first_name + "','" + last_name + "','" + email + "','" + password + "');");
		
		try {
			System.out.println("insert into user values('" + first_name + "','" + last_name + "','" + email + "','" + password + "');");
			int result = conn.update("insert into user values('" + first_name + "','" + last_name + "','" + email + "','" + password + "');");
			if(result > 0) {
				out.print( "<h1>successfully added</h1>");
			}
			else {
				out.print("Not added!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
