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
			user = new User("guest", "d80fb843776680616ec84eb3134d591d99cfb4d532e33fd525bc93137c3dd256c0bdd4f717fc4443", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
		} else {
			throw new UsernameNotFoundException(username);
		}
		
		return user;
	}

}
