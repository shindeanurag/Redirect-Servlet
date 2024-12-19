package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/loginform")
public class Ridirectservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		System.out.println(email);
		System.out.println(pass);
		
		if(email.equals("Anurag@gmail.com") && pass.equals("Anurag@123")) {
			System.out.println("Login successfully...");
			PrintWriter out=resp.getWriter();
			out.print("Login successfully...");
			RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
			rd.forward(req, resp);
		}else {
			System.out.println("Invalid user...");
			PrintWriter out=resp.getWriter();
			out.print("Invalid user...");
			resp.setContentType("text/html");
			RequestDispatcher rd=req.getRequestDispatcher("/Login.html");
			rd.include(req, resp);
		}
	}
}
