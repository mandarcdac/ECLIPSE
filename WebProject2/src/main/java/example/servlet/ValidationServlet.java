package example.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.bean.User;
import example.bean.UserValidator;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet(name = "validate", urlPatterns = {"/validate"})
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Fetching request specific parameters: uid and pwd
		//This is done using String --> value of param getParameter(String --> name of param) of HttpServletRequest
		String currentUserName = request.getParameter("uid");
		String currentPassword = request.getParameter("pwd");
		
		//Populating an object of type User based upon username and password
		User currentUser = new User(currentUserName, currentPassword);
		//Passing this object to UserValidator to check the validity
		boolean valid = UserValidator.isValid(currentUser);
		if(valid)
			out.println("<h1>Welcome to our website</h1>");
		else
			out.println("<h1>Invalid username or password.</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}