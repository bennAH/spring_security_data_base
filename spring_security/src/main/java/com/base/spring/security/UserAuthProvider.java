package com.base.spring.security;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserAuthProvider implements UserDetailsService {
	
	// wire in a dao that handles user's here.
	
	public UserAuthProvider() {
		
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = null;
		
		if (username.equals("guest")) {
			user = new User("guest", "guest", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
		} else {
			throw new UsernameNotFoundException(username);
		}
		
		return user;
	}

}
