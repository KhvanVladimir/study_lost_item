package com.example.demo.mappers;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ItemDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Item;
import com.example.demo.entity.UserDetail;

@Component
public class UtilMapper {
	
	public UserDTO toUserDTO(UserDetail userDetail) {
		return UserDTO.builder()
				.id(userDetail.getId())
				.age(userDetail.getAge()) 
				.email(userDetail.getEmail())
				.gender(userDetail.getGender())
				.phone(userDetail.getPhone())
				.role(userDetail.getRole())
				.password(userDetail.getPassword())
				.username(userDetail.getUsername()).build();
	}
	
	public UserDetail toUserDetail(UserDTO userDTO) {
		return new UserDetail(
				userDTO.getId()
				, userDTO.getUsername()
				, userDTO.getPassword()
				, userDTO.getRole()
				, userDTO.getPhone()
				, userDTO.getEmail()
				, userDTO.getAge()
				, userDTO.getGender());
	}

	public UserDTO compareAndEdit(UserDetail userDetail, UserDTO changedUser) {
		return UserDTO.builder()
				.id(userDetail.getId())
				.age(changedUser.getAge() == null ? userDetail.getAge() : changedUser.getAge())
				.email(changedUser.getEmail() == null ? userDetail.getEmail() : changedUser.getEmail())
				.gender(changedUser.getGender() == null ? userDetail.getGender() : changedUser.getGender())
				.phone(changedUser.getPhone() == null ? userDetail.getPhone() : changedUser.getPhone())
				.role(changedUser.getRole() == null ? userDetail.getRole() : changedUser.getRole())
				.password(changedUser.getPassword() == null ? userDetail.getPassword() : changedUser.getPassword())
				.username(changedUser.getUsername() == null ? userDetail.getUsername() : changedUser.getUsername())
				.build();
	}

	
	public ItemDTO toItemDTO(Item item) {
		return ItemDTO.builder()
				.id(item.getId())
				.userId(item.getUserId())
				.rowType(item.getRowType())
				.title(item.getTitle())
				.itemTypeId(item.getItemTypeId())
				.description(item.getDescription())
				.place(item.getPlace())
				.itemDate(item.getItemDate())
				.question(item.getQuestion())
				.photo(item.getPhoto())
				.status(item.getStatus()).build();
	}
	
	public Item toItem(ItemDTO itemDTO) {
		return new Item(
				itemDTO.getId()
				, itemDTO.getUserId()
				, itemDTO.getRowType()
				, itemDTO.getTitle()
				, itemDTO.getItemTypeId()
				, itemDTO.getDescription()
				, itemDTO.getPlace()
				, itemDTO.getItemDate()
				, itemDTO.getQuestion()
				, itemDTO.getPhoto()
				, itemDTO.getStatus());
	}
	public ItemDTO compareAndEdit(Item item, ItemDTO changedItem) {
		return ItemDTO.builder()
				.id(item.getId())
				.userId(item.getUserId())
				.rowType(item.getRowType())
				.title(changedItem.getTitle() == null ? item.getTitle() : changedItem.getTitle())
				.itemTypeId(changedItem.getItemTypeId() == null ? item.getItemTypeId() : changedItem.getItemTypeId())
				.description(changedItem.getDescription() == null ? item.getDescription() : changedItem.getDescription())
				.place(changedItem.getPlace() == null ? item.getPlace() : changedItem.getPlace())
				.itemDate(changedItem.getItemDate() == null ? item.getItemDate() : changedItem.getItemDate())
				.question(changedItem.getQuestion() == null ? item.getQuestion() : changedItem.getQuestion())
				.photo(changedItem.getPhoto() == null ? item.getPhoto() : changedItem.getPhoto())
				.status(changedItem.getStatus() == null ? item.getStatus() : changedItem.getStatus())
				.build();
	}
}
