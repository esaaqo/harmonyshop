package edu.mum.waa.services;

import org.springframework.stereotype.Service;

import edu.mum.waa.domain.User;
import edu.mum.waa.repositories.UserRepository;

public interface UserService {
	public User save(User user);
	public User searchByUserName(String userName);
	public User searchByEmail(String email);
	public UserRepository getUserRepository();
}
