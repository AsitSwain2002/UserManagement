package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;

@WebServlet("/reg")
public class Register extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name = req.getParameter("name");
		 int age = Integer.parseInt(req.getParameter("age"));
		 String email = req.getParameter("email");
		 String pas = req.getParameter("pas");
		 long mobile = Long.parseLong(req.getParameter("phone"));
		 
		 User user = new User();
		 user.setName(name);
		 user.setAge(age);
		 user.setEmail(email);
		 user.setPassword(pas);
		 user.setMobile(mobile);
		 
		 UserDao ud = new UserDao();
		 ud.saveUser(user);
		 
		 HttpSession session = req.getSession();
		 session.setAttribute("success", "Registration Successful");
		 resp.sendRedirect("index.jsp");
	}

}
