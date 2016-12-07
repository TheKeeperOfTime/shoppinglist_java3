package org.elevenfiftyconsulting.repositories;

import java.util.List;

import org.elevenfiftyconsulting.beans.ShoppingList;
import org.elevenfiftyconsulting.beans.User;
import org.springframework.data.repository.CrudRepository;



public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {
	
	
	List<ShoppingList> findByUserId(long id);
	List<ShoppingList> findAllByUser(User user);
	
}
