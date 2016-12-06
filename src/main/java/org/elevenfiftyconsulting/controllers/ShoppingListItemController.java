package org.elevenfiftyconsulting.controllers;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.elevenfiftyconsulting.beans.ShoppingListItem;
import org.elevenfiftyconsulting.beans.User;
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

	private static UserRepository userRepo;

    @Autowired
    private UserRepository userrRepo;

    @PostConstruct
    public void initStaticUserRepo() {
        userRepo = this.userrRepo;
    }
	
	@RequestMapping("/shoppinglist/{id}")
	public String listShoppingListItems(@PathVariable long id, Model model) {
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
	public String shoppingListItemCreate(@ModelAttribute ShoppingListItem shoppingListItem, BindingResult result, @PathVariable long id, Model model) {


		shoppingListItem.setShoppingList(shoppingListRepo.findOne(id));
		shoppingListItem.setChecked(false);
		shoppingListItem.setCreatedUtc(new Date(System.currentTimeMillis()));
		shoppingListItem.setModifiedUtc(new Date(System.currentTimeMillis()));
		shoppingListItemRepo.save(shoppingListItem);
		System.out.println(shoppingListItem.getContents());
		return "redirect:/shoppinglist/{id}";

	}
	
	@GetMapping("/shoppinglist/{id}/check/{itemid}")
	public String shoppingListItemCheck(Model model, @PathVariable(name = "id") long id,
			@PathVariable(name = "itemid") long itemid) {
		
		ShoppingListItem i = shoppingListItemRepo.findOne(itemid);
		i.setChecked(true);
		shoppingListItemRepo.save(i);
		model.addAttribute("shoppingList", shoppingListRepo.findOne(id));
		model.addAttribute("shoppingListItems", shoppingListRepo.findOne(id).getShoppingListItems());
		return "redirect:/shoppinglist/{id}";
	}
	
	@GetMapping("/shoppinglist/{id}/uncheck/{itemid}")
	public String shoppingListItemUncheck(Model model, @PathVariable(name = "id") long id,
			@PathVariable(name = "itemid") long itemid) {
		
		ShoppingListItem i = shoppingListItemRepo.findOne(itemid);
		i.setChecked(false);
		shoppingListItemRepo.save(i);
		model.addAttribute("shoppingList", shoppingListRepo.findOne(id));
		model.addAttribute("shoppingListItems", shoppingListRepo.findOne(id).getShoppingListItems());
		return "redirect:/shoppinglist/{id}";
	}
	
	// delete page view

		@GetMapping("/shoppinglist/{id}/{itemid}/delete")
		public String shoppingListItemDelete(Model model, @PathVariable(name = "id") long id, @PathVariable(name = "itemid") long itemid) {

			model.addAttribute("id", id);
			ShoppingListItem i = shoppingListItemRepo.findOne(itemid);
			model.addAttribute("shoppingListItem", i);
			model.addAttribute("shoppingList", shoppingListRepo.findOne(id));
			return "shoppinglistItem/shoppingListItemDelete";
		}

		// deletes the product after submit is pressed

		@PostMapping("/shoppinglist/{id}/{itemid}/delete")
		public String shoppingListItemDeleteSave(@PathVariable(name = "id") long id, @PathVariable(name = "itemid") long itemid, @ModelAttribute @Valid ShoppingListItem shoppingListItem,

				BindingResult result, Model model) {
				ShoppingListItem i = shoppingListItemRepo.findOne(itemid);
				System.out.println(i.getShoppingList().getId());
				shoppingListItemRepo.delete(i);
				return "redirect:/shoppinglist/{id}";
			
		}
		
		// delete page view

		@GetMapping("/shoppinglist/{id}/{itemid}/deleteAll")
		public String shoppingListItemDeleteAll(Model model, @PathVariable(name = "id") long id, @PathVariable(name = "itemid") long itemid) {

			model.addAttribute("id", id);
			ShoppingListItem i = shoppingListItemRepo.findOne(itemid);
			model.addAttribute("shoppingListItem", i);
			model.addAttribute("shoppingList", shoppingListRepo.findOne(id));
			return "shoppinglistItem/shoppingListItemDelete";
		}

		// deletes the product after submit is pressed

		@PostMapping("/shoppinglist/{id}/{itemid}/deleteAll")
		public String shoppingListItemDeleteSaveAll(@PathVariable(name = "id") long id, @PathVariable(name = "itemid") long itemid, @ModelAttribute @Valid ShoppingListItem shoppingListItem,

				BindingResult result, Model model) {
				ShoppingListItem i = shoppingListItemRepo.findOne(itemid);
				System.out.println(i.getShoppingList().getId());
				shoppingListItemRepo.delete(i);
				return "redirect:/shoppinglist/{id}";
			
		}
	
	public static User getCurrentUser (){
		User currentUser = new User();
        String email = currentUser.getUserEmail();
        currentUser = userRepo.findOneByEmail(email);
        return currentUser;
	}
	

}
