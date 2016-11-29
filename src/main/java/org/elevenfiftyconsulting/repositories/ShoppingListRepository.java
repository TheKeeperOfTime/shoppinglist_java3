package org.elevenfiftyconsulting.repositories;

import org.elevenfiftyconsulting.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer> {

}
