package controller.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customers;
import model.PasswordEncryptionWithAes;
import resources.MyConstants;

public class DbConnection {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/AttireHub",
					"root",
					"");
			System.out.println("Database connection Successful");
			return conn;
		}
		catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
			
		}
	}
	
	public ResultSet selectAllQuery(String query) {
		Connection DbConnection = getConnection();
		if(DbConnection != null) {
			try {
				PreparedStatement statement = DbConnection.prepareStatement(query);
				ResultSet result = statement.executeQuery();
				return result;
				
			}catch(SQLException ex) {
				return null;
			}
		}else {
		return null;
		}
	}
	
	public Boolean isUserRegistered(String query, String username, String password) {
		Connection DbConnection = getConnection();
		if(DbConnection != null) {
			  try {
				  PreparedStatement statement = DbConnection.prepareStatement(query);
				  statement.setString(1,username);
				  statement.setString(2, password);
				  ResultSet result = statement.executeQuery();
				  if(result.next()) return true;
				  else return false;
			  }catch(SQLException ex) {
				  return null;
			  }
			
		}else {
			return null;
		}
	}
	
	public int addCustomer(String query, Customers cusModel) {
		Connection Dbconnection = getConnection();
		if(Dbconnection != null) {
			  try {
				  PreparedStatement statement = Dbconnection.prepareStatement(query);
				  statement.setInt(1, cusModel.getCusCode());
				  statement.setString(2, cusModel.getCusName());
				  statement.setString(3, cusModel.getCusContact());
				  statement.setString(4, cusModel.getCusEmail());
				  statement.setString(5, cusModel.getCusPhoto());
				  statement.setString(6, cusModel.getDob());
				  statement.setString(7, cusModel.getGender());
				  statement.setString(8, PasswordEncryptionWithAes.encrypt(cusModel.getCusEmail(), cusModel.getPassword()));

				  int result = statement.executeUpdate();
				  System.out.println("Query Ran");
				  return result;
			  }catch(SQLException ex) {
				  System.out.println("Query didnt Ran");
				  ex.printStackTrace();
				  return -1;
				  
			  }
			
		}else {

			return -1;
		}
		
	}

}
