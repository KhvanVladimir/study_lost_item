package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
	
	Long id;
	Long userId;
	// 0001 - For found items
	// 0002 - For lost items
	String rowType;	
	String title;
	Long itemTypeId;
	String description;
	String place;
	String itemDate;
	String question;
	String photo;
	// 0001 - active
	// 0002 - inactive
	String status;
	
}
