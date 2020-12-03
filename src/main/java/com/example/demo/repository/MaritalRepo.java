package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MaritalModel;


@Repository
public interface MaritalRepo extends JpaRepository<MaritalModel, Long> 
{
	
}