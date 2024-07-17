package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.service.impl.ItemServiceImpl;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	ItemServiceImpl itemService;
    
    @GetMapping("/found")
    public List<ItemDTO> getAllFoundItems() {
        return itemService.getAllByRowType("0001");
    }
    
    @GetMapping("/lost")
    public List<ItemDTO> getAllLostItems() {
        return itemService.getAllByRowType("0002");
    }

    @GetMapping("/found/{id}")
    public List<ItemDTO> getAllFoundItemsByUserId(@PathVariable(name="id", required = true) Long id) {
        return itemService.getAllItemsByRowTypeAndUserId("0001", id);
    }

    @GetMapping("/lost/{id}")
    public List<ItemDTO> getAllLostItemsByUserId(@PathVariable(name="id", required = true) Long id) {
        return itemService.getAllItemsByRowTypeAndUserId("0002", id);
    }

    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable(name="id", required = true) Long id) {
        return itemService.findById(id);
    }

    @PostMapping("/found")
    public ItemDTO createFoundItem(@RequestBody ItemDTO item) {
    	item.setRowType("0001");
        return itemService.save(item);
    }
    
    @PostMapping("/lost")
    public ItemDTO createLostItem(@RequestBody ItemDTO item) {
    	item.setRowType("0002");
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public ItemDTO updateItem(@PathVariable(name="id", required = true) Long id, @RequestBody ItemDTO changedItem) {
    	Optional<Item> item = itemService.findItemById(id);
        if(item.isEmpty()) {
        	throw new RuntimeException("Item not found with id " + id);
        }
    	return itemService.changeItem(item.get(), changedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable(name="id", required = true) Long id) {
        itemService.deleteById(id);
    }
	
}
