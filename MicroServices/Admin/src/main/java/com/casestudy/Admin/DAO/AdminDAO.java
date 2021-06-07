package com.casestudy.Admin.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Admin.Models.Admin;

public interface AdminDAO extends MongoRepository<Admin, String> {

}
