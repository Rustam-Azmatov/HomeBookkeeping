package ru.azmatov.HomeBookkeeping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "operation_type", schema = "bookeeping")
@Data
public class OperationTypeEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String typeTitle;
	
	@Column
	private String typeName;
	
}
