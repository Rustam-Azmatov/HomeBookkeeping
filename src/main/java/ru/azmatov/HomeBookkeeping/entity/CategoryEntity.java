package ru.azmatov.HomeBookkeeping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category", schema = "bookeeping")
@Data
public class CategoryEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String categoryName;
}
