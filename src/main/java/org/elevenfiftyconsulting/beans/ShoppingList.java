package org.elevenfiftyconsulting.beans;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "Shopping_List")
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;

	private String color;

	private String name;

	private OffsetDateTime createdUtc;
	private OffsetDateTime modifiedUtc;
	
	public ShoppingList(){}
	
	public ShoppingList(String name, OffsetDateTime createdUtc, OffsetDateTime modifiedUtc){
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

	public OffsetDateTime getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(OffsetDateTime createdUtc) {
		this.createdUtc = createdUtc;
	}

	public OffsetDateTime getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc(OffsetDateTime modifiedUtc) {
		this.modifiedUtc = modifiedUtc;
	}

}
