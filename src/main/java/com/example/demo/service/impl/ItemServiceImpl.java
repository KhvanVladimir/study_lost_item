package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.mappers.UtilMapper;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl {

	@Autowired
	ItemRepository itemRepository;
	@Autowired
	UtilMapper utilMapper;
	
	public List<ItemDTO> getAllByRowType(String rowType) {
		return itemRepository.findByRowType(rowType).stream().map((x) -> utilMapper.toItemDTO(x)).toList();
	}

	public List<ItemDTO> getAllItemsByRowTypeAndUserId(String rowType, Long userId) {
		return itemRepository.findByRowTypeAndUserId(rowType, userId).stream().map((x) -> utilMapper.toItemDTO(x)).toList();
	}

	public ItemDTO findById(Long id) {
		Optional<Item> item = itemRepository.findById(id);
		return item.isEmpty() ? null : utilMapper.toItemDTO(item.get());		
	}

	public ItemDTO save(ItemDTO item) {
		Item result = itemRepository.save(utilMapper.toItem(item));
		return utilMapper.toItemDTO(result);
	}

	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}

	public Optional<Item> findItemById(Long id) {
		return itemRepository.findById(id);
	}

	public ItemDTO changeItem(Item item, ItemDTO changedItem) {
		ItemDTO result = utilMapper.compareAndEdit(item, changedItem);
		return save(result);
	}

}
