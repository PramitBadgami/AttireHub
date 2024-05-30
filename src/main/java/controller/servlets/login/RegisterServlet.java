package controller.servlets.login;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.dbconnection.DbConnection;
import model.Customers;
import resources.MyConstants;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported = true, urlPatterns= "/RegisterServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
	maxFileSize = 1024*1024*10,
	maxRequestSize = 1024*1024*50)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		String cusName = fname + " " + lname;
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender"); 
		String email = request.getParameter("register-email");
		String phone = request.getParameter("register-phone");
		String password = request.getParameter("register-password");
		String cPassword = request.getParameter("confirm-password");
		Part image = request.getPart("image");
		String imageName = image.getSubmittedFileName();
		
		
		
		
		DbConnection connection = new DbConnection();
		ResultSet cusResult = connection.selectAllQuery(MyConstants.GET_USERS_INFO);
		int prevCusCode = 0;
		try {
			if(cusResult != null && cusResult.next()) {
				while(cusResult.next()) {
					prevCusCode = cusResult.getInt("cus_code") + 1;
				}

			}else {
				prevCusCode = 0;
			}
			int cusCode = prevCusCode + 1;
			Customers customerModel = new Customers(cusCode, cusName, phone, email, imageName, 0, image, dob, gender, password);
			int result = connection.addCustomer(MyConstants.ADD_USER, customerModel);
			System.out.println(result);
			if(result > 0) {
				System.out.println("insert vaio");
			}else {
				System.out.println("insert vaienas");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
