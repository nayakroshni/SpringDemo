package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserService
{
	public UserModel save(UserModel userModel);
	public UserModel findById(Integer userID);
	public void deleteById(Integer userID);
	public List<UserModel> findAll();
}
