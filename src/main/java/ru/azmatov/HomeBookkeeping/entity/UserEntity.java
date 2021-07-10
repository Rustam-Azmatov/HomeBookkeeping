package ru.azmatov.HomeBookkeeping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users", schema = "bookeeping")
@Data
public class UserEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String login;
	
	@Column
	private String password;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String isAdmin;
}
