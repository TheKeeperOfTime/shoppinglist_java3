package org.elevenfiftyconsulting.security;

import static org.elevenfiftyconsulting.security.Role.ROLE_ADMIN;
import static org.elevenfiftyconsulting.security.Role.ROLE_USER;


import static org.springframework.security.core.context.SecurityContextHolder.getContext;

import java.util.List;

import org.elevenfiftyconsulting.beans.User;
import org.elevenfiftyconsulting.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;



//Used on service-layer classes to specify intent
@Service 
public class PermissionService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	
	private AbstractAuthenticationToken getToken() { 
		return (AbstractAuthenticationToken) 
		getContext().getAuthentication();
	}
	
	public boolean hasRole(Role role) {
		for(GrantedAuthority ga : getToken().getAuthorities()){ 
			if(role.toString().equals(ga.getAuthority())){ 
				return true;
			}
		}
		return false;
	}
	
	public boolean canAccessUser(long userId) {
		return hasRole(ROLE_ADMIN) || (hasRole(ROLE_USER) && findCurrentUserId() == userId);
	}
	
	public long findCurrentUserId(){
		List<User> users = userRepo.findByEmail(getToken().getName());
		return users !=null && !users.isEmpty() ? users.get(0).getId() :-1;
	}
	
	
	public User findCurrentUser() {
		List<User> users = userRepo.findByEmail(getToken().getName());
		return users != null && !users.isEmpty() ? users.get(0) : new User();
	}

//	public boolean canEditContact(long contactId) {
//		return hasRole(ROLE_USER) && contactRepo.findByUserIdAndId(findCurrentUserId(), contactId) != null;
//	}
	
	public String getCurrentEmail() {
		return getToken().getName();
	}
	
	

}
