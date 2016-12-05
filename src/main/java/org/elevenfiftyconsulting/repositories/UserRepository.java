package org.elevenfiftyconsulting.repositories;

import java.util.List;

import org.elevenfiftyconsulting.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	

	User findOneByEmail(String email);
	
	List<User> findByEmail(String email);
	
	List<User> findAllByOrderByFirstNameAscLastNameAsc();

}
