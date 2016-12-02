package org.elevenfiftyconsulting.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.elevenfiftyconsulting.beans.ShoppingListItem;
import org.elevenfiftyconsulting.repositories.ShoppingListItemRepository;
import org.elevenfiftyconsulting.repositories.ShoppingListRepository;
import org.elevenfiftyconsulting.repositories.UserRepository;
import org.elevenfiftyconsulting.security.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingListItemController {

	@Autowired
	private ShoppingListItemRepository shoppingListItemRepo;

	@Autowired
	private ShoppingListRepository shoppingListRepo;

	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/shoppinglist/{id}")
	public String listShoppingListItems(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		
		ShoppingListItem i = shoppingListItemRepo.findOne(id);
		model.addAttribute("shoppingListItems", i);
		return "shoppingListItem/shoppingListItems";
	}
	
	//create view shoppingListItem
	@GetMapping("/shoppinglistitem/create")
	public String shoppingListItemCreate(Model model) {
		model.addAttribute(new ShoppingListItem());
		return "shoppingListItem/shoppingListItemCreate";
	}
	
	//save created shoppingListItem
	@PostMapping("/shoppinglistitem/create")
	public String shoppingListItemCreate(@ModelAttribute @Valid ShoppingListItem shoppingListItem, BindingResult result, Model model) {

		
		
		shoppingListItem.setPriority(Priority.HIGH);
		shoppingListItem.getPriority();
		shoppingListItem.setCreatedUtc(new Date(System.currentTimeMillis()));
		shoppingListItem.setModifiedUtc(new Date(System.currentTimeMillis()));
		shoppingListItemRepo.save(shoppingListItem);
		return "redirect:/shoppinglist/{id}";

	}
	

}
