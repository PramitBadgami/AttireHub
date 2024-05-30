package resources;

import java.io.File;

public class MyConstants {
	//database connection queries
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql//localhost:3306/AttireHub";
	public static final String DB_USER_NAME = "root";
	public static final String  DB_USER_PASSWORD = "";
	
	//database queries
	public static final String GET_USERS_INFO = "SELECT * FROM customers";
	public static final String GET_ADMIN_INFO = "SELECT * FROM admins";
	public static final String GET_PRODUCTS_INFO = "SELECT * FROM products";
	public static final String DELETE_USER_USING_ID = "DELETE FROM cusotmers WHERE cus_code = ?";
	public static final String SELL_PRODUCT_QUERY = "UPDATE Products SET product_stock_quantity = product_stock_quantity - ? WHERE product_code = ?";
	public static final String ADD_EXISTING_PRODUCT_QUERY = "UPDATE Products SET product_stock_quantity = product_stock_quantity + ? WHERE product_code = ?";
	public static final String ADD_USER = "INSERT INTO customers(cus_code, cus_name, cus_contact, cus_email, cus_photo, cus_DOB, cus_gender, cus_password) VALUES (?,?,?,?,?,?,?,?)";
	public static final String ADD_NEW_PRODUCT = "INSERT INTO products VALUES(?,?,?,?,?,?,?,?)";

	public static final String IMAGE_DIR = "xampp\\tomcat\\wenapps\\images\\";
	public static final String IMAGE_DIR_SAVE_PATH = "C:" + File.separator + IMAGE_DIR;
}
