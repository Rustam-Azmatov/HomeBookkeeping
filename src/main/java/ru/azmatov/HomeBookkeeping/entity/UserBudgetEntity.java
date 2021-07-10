package ru.azmatov.HomeBookkeeping.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ru.azmatov.HomeBookkeeping.constants.Role;

import lombok.Data;

@Entity
@Table(name = "user_budget", schema = "bookeeping")
@Data
public class UserBudgetEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "budget_id")
	private BudgetEntity budget;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
}
