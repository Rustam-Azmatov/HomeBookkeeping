package ru.azmatov.HomeBookkeeping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation", schema = "bookeeping")
public class OperationEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "operation_type_id")
	private OperationTypeEntity operationType;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
}
