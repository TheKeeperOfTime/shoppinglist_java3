package org.elevenfiftyconsulting.controllers;
//
//import static com.users.security.Role.ROLE_USER;

import java.util.Date;

import org.elevenfiftyconsulting.beans.ShoppingList;
import org.elevenfiftyconsulting.beans.User;
//import org.elevenfiftyconsulting.repositories.NoteRepository;
import org.elevenfiftyconsulting.repositories.ShoppingListRepository;
import org.elevenfiftyconsulting.repositories.UserRepository;
//import org.elevenfiftyconsulting.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.users.beans.User;
//import com.users.beans.UserRole;

@Controller
public class ShoppingListController {

//	@Autowired
//	private NoteRepository noteRepo;


	@Autowired
	private ShoppingListRepository shoppingListRepo;

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		return "index";
	}
	
	
	
	@RequestMapping("/shoppinglists")
	public String shoppingLists(Model model) {
		model.addAttribute("shoppingLists", shoppingListRepo.findAll());
		return "shoppingList/shoppingList";
	}

	@GetMapping("/shoppinglist/create")
	public String shoppingListCreate(Model model) {
		model.addAttribute("shoppingList", new ShoppingList());
		return "shoppingList/shoppingListCreate";
	}
	
	@PostMapping("/shoppinglist/create")
	public String shoppingListCreate(@ModelAttribute ShoppingList shoppingList, BindingResult result, Model model) {

//		if (result.hasErrors()) {
//			model.addAttribute("shoppingList", shoppingList);
//			return "shoppingListItem/shoppingListCreate";
//		} else {
//			shoppingListRepo.save(shoppingList);
//			return "redirect:/shoppinglists";
//		}
		
//		User u = new User();
//		u.setFirstName("bob");
//		u.setLastName("bobby");
//		u.setEmail("bobby@bobbysworld.com");
//		u.setActive(true);
//		userRepo.save(u);
//		shoppingList.setUser(u);
		shoppingList.setCreatedUtc(new Date(System.currentTimeMillis()));
		shoppingList.setModifiedUtc(new Date(System.currentTimeMillis()));
		shoppingListRepo.save(shoppingList);
		return "redirect:/shoppinglists";

	}

	



}
