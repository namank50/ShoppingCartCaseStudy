package com.casestudy.APIGateway.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.APIGateway.Model.SecurityRequest;
import com.casestudy.APIGateway.Model.SecurityResponse;
import com.casestudy.APIGateway.Service.MyUsersDetailService;
import com.casestudy.APIGateway.Service.SecurityService;
import com.casestudy.APIGateway.Util.JwtUtil;


@RestController
@RequestMapping("/security")
@CrossOrigin(origins = "http://localhost:4200")
public class SecurityController {
	@Autowired
	SecurityService securityService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUsersDetailService userDetailsService;
	
	@Autowired
	private JwtUtil jwtToken;
	
	@GetMapping("/delete/{_id}")
	public String save(@PathVariable("_id")String _id) {
		return securityService.deleteData(_id);
	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody SecurityRequest securityRequest)
	throws Exception{
		try
		{
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(securityRequest.getUsername(), securityRequest.getPassword())
				);
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect Username or password",e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(securityRequest.getUsername());
		final String jwt = jwtToken.generateToken(userDetails);
		return ResponseEntity.ok(new SecurityResponse(jwt));
		
	}

}
