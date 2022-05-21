package com.capg.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User_Table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_Id", length = 10)
	private int userId;
	@Column(name = "user_name", length = 25)
	private String userName;
	@Column(name = "role", length = 25)
	private String role;
	@Column(name = "user_password", length = 25)
	private String userPassword;
	public Integer updateUser() {
		// TODO Auto-generated method stub
		return null;
	}
}