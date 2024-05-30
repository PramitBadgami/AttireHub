package model;

public class Admins {
	private int admin_code;
	private String admin_name;
	private String admin_contact;
	private String admin_email;
	private String admin_photo;
	
	public Admins(){ };
	
	public Admins(int admin_code,String admin_name, String admin_contact, String admin_email, String admin_photo) {
		this.admin_code = admin_code;
		this.admin_name = admin_name;
		this.admin_contact = admin_contact;
		this.admin_email = admin_email;
		this.admin_photo = admin_photo;
	}

	public int getAdmin_code() {
		return admin_code;
	}

	public void setAdmin_code(int admin_code) {
		this.admin_code = admin_code;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_contact() {
		return admin_contact;
	}

	public void setAdmin_contact(String admin_contact) {
		this.admin_contact = admin_contact;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_photo() {
		return admin_photo;
	}

	public void setAdmin_photo(String admin_photo) {
		this.admin_photo = admin_photo;
	}
	
	

}
