package edu.mum.waa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	User findById(Long userId);
	public void deleteById(Long userId);
	public User findByUserName(String username);
	public User findByEmail(String email);
}
