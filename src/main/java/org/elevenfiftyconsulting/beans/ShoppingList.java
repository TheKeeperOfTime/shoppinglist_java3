package org.elevenfiftyconsulting.beans;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "Shopping_List")
public class ShoppingList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(optional=false)
    @JoinColumn(name="user_id")
	private User userId;
	
	private String color;
	
	private String name;
	
	private OffsetDateTime createdUtc;
	private OffsetDateTime modifiedUtc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
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
