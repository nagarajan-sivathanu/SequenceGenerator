package com.learn.springboot.SequenceGenerator.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.springboot.SequenceGenerator.pojo.User;

@Repository
public interface UserDao extends MongoRepository<User,String> {
	@Autowired
    MongoTemplate mongoTemplate=null;
}
