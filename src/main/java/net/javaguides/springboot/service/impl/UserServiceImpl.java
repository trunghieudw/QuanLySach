package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.service.*;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("User", "Id", id));
		
	}

	@Override
	public User updateUser(User user, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", id)); 
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		// save existing employee to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		
		// check whether a employee exist in a DB or not
		userRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);
	}
	
}
