package com.maintenance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="users")
@NamedQueries({
		@NamedQuery(name="User.findAll" ,query="SELECT u FROM User u ORDER BY u.fullName"),
		@NamedQuery(name="User.findByEmail" ,query="SELECT u FROM User u WHERE u.email= :email"),
		@NamedQuery(name="User.countAll" ,query="SELECT Count(u) from User u "),
		@NamedQuery(name="User.checkLogin" ,query="SELECT u FROM User u WHERE u.email= :email AND password= :pass")
})
public class User {
	
	public User() {}
	
	
	private int userId;
	private String fullName;
	private String email;
	private String password;
	
	
	public User(int userId, String fullName, String email, String password) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}
	public User(String fullName, String email, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}
	
	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="full_name")
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ "]";
	}

	
	
}
