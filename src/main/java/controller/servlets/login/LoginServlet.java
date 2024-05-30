package controller.servlets.login;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.dbconnection.DbConnection;
import resources.MyConstants;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		DbConnection connection = new DbConnection();
		Boolean isUserRegistered = connection.isUserRegistered(MyConstants.GET_USERS_INFO, username, password);
		if(isUserRegistered != null && isUserRegistered) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			
			Cookie userName = new Cookie("user", username);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("index.jsp");
		}else {
			request.setAttribute("errorMessage", "Invali username or password");
			RequestDispatcher inc = request.getRequestDispatcher("index.jsp");
			inc.include(request, response);
		}
		
		doGet(request, response);
	}

}
