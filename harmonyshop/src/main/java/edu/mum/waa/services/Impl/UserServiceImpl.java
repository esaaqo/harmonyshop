package edu.mum.waa.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.User;
import edu.mum.waa.repositories.UserRepository;
import edu.mum.waa.services.UserService;

@Service
public class UserServiceImpl implements UserService {
		
	UserRepository userRepository;
		
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User save(User user){
		userRepository.save(user);
		return user;
	}
	
	public User searchByUserName(String userName){
		return userRepository.findByUserName(userName);
	}
	public User searchByEmail(String email){
		System.out.println("email is: " + email);
		return userRepository.findByEmail(email);
	}
	public UserRepository getUserRepository() {
		return userRepository;
	}
	
}
