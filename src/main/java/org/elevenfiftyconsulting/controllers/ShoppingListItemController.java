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
		model.addAttribute("shoppingList", shoppingListRepo.findOne(id));
		model.addAttribute("shoppingListItems", shoppingListRepo.findOne(id).getShoppingListItems());
		return "shoppingListItem/shoppingListItems";
	}
	
	@GetMapping("/shoppinglist/{id}/create")
	public String shoppingListItemCreate(Model model) {
		model.addAttribute("shoppingListItem", new ShoppingListItem());
		return "shoppingListItem/shoppingListItemCreate";
	}
	
	@PostMapping("/shoppinglist/{id}/create")
	public String shoppingListItemCreate(@ModelAttribute ShoppingListItem shoppingListItem, BindingResult result, @PathVariable int id, Model model) {


		shoppingListItem.setShoppingList(shoppingListRepo.findOne(id));
		shoppingListItem.setPriority(Priority.HIGH);
		shoppingListItem.setCreatedUtc(new Date(System.currentTimeMillis()));
		shoppingListItem.setModifiedUtc(new Date(System.currentTimeMillis()));
		shoppingListItemRepo.save(shoppingListItem);
		System.out.println(shoppingListItem.getContents());
		return "redirect:/shoppinglist/{id}";

	}
	
	// delete page view
		@GetMapping("/shoppinglistitem/{id}/delete")
		public String shoppingListItemDelete(Model model, @PathVariable(name = "id") int id) {
			model.addAttribute("id", id);
			ShoppingListItem i =shoppingListItemRepo.findOne(id);
			model.addAttribute("shoppingListItem", i);
			return "shoppinglistItem/shoppingListItemDelete";
		}

		// deletes the product after submit is pressed
		@PostMapping("/shoppinglistitem/{id}/delete")
		public String shoppingListItemDeleteSave(@PathVariable(name = "id") int id, @ModelAttribute @Valid ShoppingListItem shoppingListItem,
				BindingResult result, Model model) {
			if (result.hasErrors()) {
				model.addAttribute("shoppingListItem", shoppingListItem);
				return "shoppingListItem/shoppingListItems";
			} else {
				shoppingListItemRepo.delete(shoppingListItem);
				return "redirect:/shoppinglists";
			}
		}
	

}
