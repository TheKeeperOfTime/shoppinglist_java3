package org.elevenfiftyconsulting.repositories;

import java.util.List;

import org.elevenfiftyconsulting.beans.UserRole;
import org.springframework.data.repository.CrudRepository;



public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
	
	List<UserRole> findByUserId(long userId);

}
