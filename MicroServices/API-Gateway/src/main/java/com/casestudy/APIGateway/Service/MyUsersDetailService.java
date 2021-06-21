package com.casestudy.APIGateway.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.casestudy.APIGateway.DAO.SecurityDatabase;
import com.casestudy.APIGateway.Model.SecurityData;

@Service
public class MyUsersDetailService implements UserDetailsService {

	@Autowired
	SecurityDatabase userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<SecurityData> user =userRepo.findById(username);
		System.out.println(user);
		user.orElseThrow(()->new UsernameNotFoundException("User Not Found" +username));
		
		return user.map(MyUserDetails::new).get();
	}

}
