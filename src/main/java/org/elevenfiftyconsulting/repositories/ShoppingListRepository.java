package org.elevenfiftyconsulting.repositories;

import java.util.List;

import org.elevenfiftyconsulting.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;



public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer> {
	
	List<ShoppingList> findByUserId(long userId);
	
}
