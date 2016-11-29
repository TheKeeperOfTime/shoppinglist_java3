package org.elevenfiftyconsulting.controllers;

import org.elevenfiftyconsulting.repositories.NoteRepository;
import org.elevenfiftyconsulting.repositories.ShoppingListItemRepository;
import org.elevenfiftyconsulting.repositories.ShoppingListRepository;
import org.elevenfiftyconsulting.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingListController {

	@Autowired
	private NoteRepository noteRepo;

	@Autowired
	private ShoppingListItemRepository shoppingListItemRepo;

	@Autowired
	private ShoppingListRepository shoppingListRepo;

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/")
	public String home(Model model) {
		return "shoppingList";
	}

	@RequestMapping("shoppingList/{shoppingListId}")
	public String listShoppingListItems(@PathVariable int shoppingListId, Model model) {
		model.addAttribute("shoppingListItems", shoppingListRepo.findByShoppingListId(shoppingListId));
		return "shoppingListItems";
	}

}
