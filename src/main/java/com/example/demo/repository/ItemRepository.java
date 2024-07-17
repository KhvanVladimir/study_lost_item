package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findByRowType(String rowType);
	
	List<Item> findByUserId(Long userId);

	List<Item> findByRowTypeAndUserId(String rowType, Long userId);
}
