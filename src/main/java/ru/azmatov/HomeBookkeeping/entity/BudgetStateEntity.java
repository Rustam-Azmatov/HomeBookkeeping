package ru.azmatov.HomeBookkeeping.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import ru.azmatov.HomeBookkeeping.constants.StateType;

@Entity
@Table(name="budget_state", schema = "bookeeping")
@Data
public class BudgetStateEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private BigDecimal sum;
	
	@Enumerated(EnumType.STRING)
	private StateType stateType;
	
	@Column
	private String state_name;
	
	@ManyToOne
	@JoinColumn(name = "budget_id")
	private BudgetEntity budget;
}
