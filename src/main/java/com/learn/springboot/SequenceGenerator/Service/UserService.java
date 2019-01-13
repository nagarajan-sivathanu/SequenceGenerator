package com.learn.springboot.SequenceGenerator.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.SequenceGenerator.Dao.UserDao;
import com.learn.springboot.SequenceGenerator.pojo.Counter;
import com.learn.springboot.SequenceGenerator.pojo.User;

@Service
public class UserService {
	@Autowired 
	private CounterService counterService;
	@Autowired 
	private UserDao userDao;
	 
	private User user1;
	
	public void saveUser() {
		try {

			System.out.println("Inside UserService --> saveUser()");
			
			User user1 = new User();
			user1.setId(counterService.getNextSequence("counters"));
			user1.setName("Nagaraj");
			
			User user2 = new User();
			User user3 = new User();
			user2.setId(counterService.getNextSequence("counters"));
			user2.setName("Hari");
			user3.setId(counterService.getNextSequence("counters"));
			user3.setName("Chumesh");
			userDao.insert(user1);
			userDao.insert(user2);
			userDao.insert(user3);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
