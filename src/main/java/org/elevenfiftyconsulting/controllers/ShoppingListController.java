package org.elevenfiftyconsulting.controllers;
//

//import static com.users.security.Role.ROLE_USER;

import java.util.Date;

import javax.annotation.PostConstruct;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.users.beans.User;
//import com.users.beans.UserRole;

@Controller
public class ShoppingListController {

	// @Autowired
	// private NoteRepository noteRepo;

	@Autowired
	private ShoppingListRepository shoppingListRepo;

	private static UserRepository userRepo;

	@Autowired
	private UserRepository userrRepo;

	@PostConstruct
	public void initStaticUserRepo() {
		userRepo = this.userrRepo;
	}

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
		User currentUser = ShoppingListController.getCurrentUser();
		model.addAttribute("shoppingLists", shoppingListRepo.findAllByUser(currentUser));
		return "shoppingList/shoppingList";
	}

	@GetMapping("/shoppinglist/create")
	public String shoppingListCreate(Model model) {
		model.addAttribute("shoppingList", new ShoppingList());
		return "shoppingList/shoppingListCreate";
	}

	@PostMapping("/shoppinglist/create")
	public String shoppingListCreate(@ModelAttribute ShoppingList shoppingList, BindingResult result, Model model) {
		User currentUser = ShoppingListController.getCurrentUser();
		if (result.hasErrors()) {
			model.addAttribute("shoppingList", shoppingList);
			return "shoppingListItem/shoppingListCreate";
		} else {
			shoppingList.setUser(currentUser);
			shoppingList.setCreatedUtc(new Date(System.currentTimeMillis()));
			shoppingList.setModifiedUtc(new Date(System.currentTimeMillis()));
			shoppingListRepo.save(shoppingList);
			return "redirect:/shoppinglists";
		}
	}

	public static User getCurrentUser() {
		User currentUser = new User();
		String email = currentUser.getUserEmail();
		currentUser = userRepo.findOneByEmail(email);
		return currentUser;
	}

}
