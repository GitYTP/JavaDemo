package com.ytp.test.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="users")
@Table(name="users")
public class User {
	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name")

	private String userName;
	@Column(name="email")

	private String address;
	@Column(name="address")

	private String email;
	@Column(name="status")

	private String status;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User(){

	}
	public User(int userId, String userName, String address, String email, String status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.email = email;
		this.status = status;
	}
}
