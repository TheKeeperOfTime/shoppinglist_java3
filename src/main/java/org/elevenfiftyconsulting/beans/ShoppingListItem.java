package org.elevenfiftyconsulting.beans;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "items")
public class ShoppingListItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "shopping_list_id")
	private ShoppingList shoppingList;

	private String contents;
	private int priority;
	private boolean isChecked;
	private OffsetDateTime createdUtc;
	private OffsetDateTime modifiedUtc;
	
	public ShoppingListItem(){}

	public ShoppingListItem(String Contents, int Priority, boolean isChecked, OffsetDateTime CreatedUtc,
			OffsetDateTime ModifiedUtc) {
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
		contents = contents;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		priority = priority;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public OffsetDateTime getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(OffsetDateTime createdUtc) {
		createdUtc = createdUtc;
	}

	public OffsetDateTime getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc(OffsetDateTime modifiedUtc) {
		modifiedUtc = modifiedUtc;
	}

}
