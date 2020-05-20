package model;

public class User {
	private int uid;
	private String uname;
	private String pass;
	private String mail;

	public User(int uid, String uname, String pass, String mail) {
		this.uid = uid;
		this.uname = uname;
		this.pass = pass;
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}



}
