package org.elevenfiftyconsulting.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "shopping_list_items")
public class ShoppingListItem {

	@Id
	@GeneratedValue(generator="myGenerator")
	@GenericGenerator(name="myGenerator", strategy="foreign", parameters=@Parameter (value="user", name = "property"))
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "shopping_list_id")
	private ShoppingList shoppingList;

	private String contents;
	private int priority;
	private boolean isChecked;
	private Date createdUtc;
	private Date modifiedUtc;
	
	public ShoppingListItem(){}

	public ShoppingListItem(String Contents, int Priority, boolean isChecked, Date CreatedUtc,
			Date ModifiedUtc) {
		this.contents = Contents;
		this.priority = Priority;
		this.isChecked = isChecked;
		this.createdUtc = CreatedUtc;
		this.modifiedUtc = ModifiedUtc;
	}

	
	@Override
	public String toString() {
		return "ShoppingListItem [id=" + id + ", shoppingList=" + shoppingList + ", contents=" + contents
				+ ", priority=" + priority + ", isChecked=" + isChecked + ", createdUtc=" + createdUtc
				+ ", modifiedUtc=" + modifiedUtc + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}


	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}


	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
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
