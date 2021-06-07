package com.casestudy.Admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Admin.DAO.AdminDAO;
import com.casestudy.Admin.Models.Admin;

@Service
public class TestService {
	
	@Autowired
	private AdminDAO repository;
	
	public List<Admin> getAllData() {
		System.out.println(repository.findAll());
		return repository.findAll();
	}

}
