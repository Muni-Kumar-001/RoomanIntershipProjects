package com.facebook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegisterSrv
 */
@WebServlet("/RegisterSrv")
public class RegisterSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//general settings
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter(); 
		
		//Request data gathering logic
		String uName = request.getParameter("username");
		String pswd = request.getParameter("password");

		//Business logic
		int caps=0,lwr=0,spcCase=0,space=0;
		if(!(pswd.charAt(0)>=0 && pswd.charAt(0)<=9 && pswd.charAt(0)==' ') && pswd.length()>7) {
			for(int i=0;i<pswd.length();i++) {
				char ch=pswd.charAt(i);
				if(ch ==' ') space++;
				else if(ch>='a' && ch<='z') lwr++;
				else if(ch>='A' && ch<='Z') caps++;
				else if(ch =='@' || ch == '_' || ch == '$' || ch == '#') spcCase++;
			}
			if(caps>0 && lwr>0 && spcCase>0 && space==0)
				response.sendRedirect("Login.html");
			else
				pw.println("please make neccessary elements in the password" +caps+" "+lwr+" "+spcCase);
		}
		else {
			pw.println("Check your details");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
