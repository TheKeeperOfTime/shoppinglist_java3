 package org.elevenfiftyconsulting.beans;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;

	private String color;

	private String name;

	private Date createdUtc;
	private Date modifiedUtc;

	@OneToMany(mappedBy = "shoppingList")
	private List<ShoppingListItem> shoppingListItems;

	public ShoppingList() {
	}

	public ShoppingList(String name, Date createdUtc, Date modifiedUtc) {
		this.name = name;
		this.createdUtc = createdUtc;
		this.modifiedUtc = modifiedUtc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(Date createdUtc) {
		this.createdUtc = createdUtc;
	}

	public Date getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc(Date modifiedUtc) {
		this.modifiedUtc = modifiedUtc;
	}

}
