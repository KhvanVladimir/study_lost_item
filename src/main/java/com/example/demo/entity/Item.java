package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="items")
public class Item{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "user_id")
	Long userId;
	
	// 0001 - For found things
	// 0002 - For lost items
	@Column(name = "row_type")
	String rowType;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "item_type_id")
	Long itemTypeId;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "place")
	String place;
	
	@Column(name = "item_date")
	String itemDate;
	
	@Column(name = "question")
	String question;
	
	@Column(name = "photo")
	String photo;
	
	// 0001 - active
	// 0002 - inactive
	@Column(name = "status")
	String status;
	
}
