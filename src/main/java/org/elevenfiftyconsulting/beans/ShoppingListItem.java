package org.elevenfiftyconsulting.beans;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ShoppingListItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int shoppingListId;

	private String contents;
	private int priority;
	private boolean isChecked;
	private OffsetDateTime createdUtc;
	private OffsetDateTime modifiedUtc;

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
		return "ShoppingListItem [id=" + id + ", Shopping_List_Id=" + shoppingListId + ", "
				+ (contents != null ? "Contents=" + contents + ", " : "") + "Priority=" + priority + ", isChecked="
				+ isChecked + ", " + (createdUtc != null ? "CreatedUtc=" + createdUtc + ", " : "")
				+ (modifiedUtc != null ? "ModifiedUtc=" + modifiedUtc : "") + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShoppingListId() {
		return shoppingListId;
	}

	public void setShoppingListId(int shoppingListId) {
		shoppingListId = shoppingListId;
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
