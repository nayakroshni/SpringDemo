package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepo;


@Service
@Transactional
public class UserServiceImp implements UserService
{
	@Autowired
	UserRepo userRepo;

	@Override
	public UserModel save(UserModel userModel)
	{
		// TODO Auto-generated method stub
		return userRepo.save(userModel);
	}

	@Override
	public UserModel findById(Integer userID)
	{
		// TODO Auto-generated method stub
		return userRepo.findById(userID).orElse(null);
	}

	@Override
	public List<UserModel> findAll()
	{
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void deleteById(Integer userID)
	{
		userRepo.deleteById(userID);
	}

}
