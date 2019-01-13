package com.learn.springboot.SequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.springboot.SequenceGenerator.Service.UserService;

@SpringBootApplication
public class App 
{
	@Autowired 
	private UserService userService;
	public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
		System.out.println("Spring Boot App has been executed Successfully");
		
    }
}
