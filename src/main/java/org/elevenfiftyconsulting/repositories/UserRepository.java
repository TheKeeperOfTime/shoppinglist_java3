package org.elevenfiftyconsulting.repositories;

import org.elevenfiftyconsulting.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
