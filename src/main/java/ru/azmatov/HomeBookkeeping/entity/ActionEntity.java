package ru.azmatov.HomeBookkeeping.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "action", schema = "bookeep")
@Data
public class ActionEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Short actionType;
	
	@Column
	private BigDecimal sum;
	
	@Column
	private BigDecimal totalSum;
	
	@ManyToOne
	@JoinColumn(name = "budget_state_id")
	private BudgetStateEntity budgetState;
	
	@ManyToOne
	@JoinColumn(name = "operation_id")
	private OperationEntity operationEntity;
	
	@Column
	private LocalDateTime localDateTime;
}
