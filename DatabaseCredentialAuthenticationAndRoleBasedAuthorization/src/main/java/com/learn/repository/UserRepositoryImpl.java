package com.learn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.model.User;
import com.learn.security.MyUserDetails;

@Service
public class UserRepositoryImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= userRepository.getUserByUsername(username);
		if(null==user) {
			throw new  UsernameNotFoundException("User "+username+" not found Exception");
		}else {
			System.out.println("User exist in DB :"+user);
			return new MyUserDetails(user);
		}
		
	}

}
