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
	private int Shopping_List_Id;
	
	private String Contents;
	private int Priority;
	private boolean isChecked;
	private OffsetDateTime CreatedUtc;
	private OffsetDateTime  ModifiedUtc;
	
	public ShoppingListItem(String Contents, int Priority, boolean isChecked, OffsetDateTime CreatedUtc, OffsetDateTime ModifiedUtc){
		this.Contents = Contents;
		this.Priority = Priority;
		this.isChecked = isChecked;
		this.CreatedUtc = CreatedUtc;
		this.ModifiedUtc = ModifiedUtc;
	}
	
	@Override
	public String toString() {
		return "ShoppingListItem [id=" + id + ", Shopping_List_Id=" + Shopping_List_Id + ", "
				+ (Contents != null ? "Contents=" + Contents + ", " : "") + "Priority=" + Priority + ", isChecked="
				+ isChecked + ", " + (CreatedUtc != null ? "CreatedUtc=" + CreatedUtc + ", " : "")
				+ (ModifiedUtc != null ? "ModifiedUtc=" + ModifiedUtc : "") + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShopping_List_Id() {
		return Shopping_List_Id;
	}

	public void setShopping_List_Id(int shopping_List_Id) {
		Shopping_List_Id = shopping_List_Id;
	}

	public String getContents() {
		return Contents;
	}

	public void setContents(String contents) {
		Contents = contents;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public OffsetDateTime getCreatedUtc() {
		return CreatedUtc;
	}

	public void setCreatedUtc(OffsetDateTime createdUtc) {
		CreatedUtc = createdUtc;
	}

	public OffsetDateTime getModifiedUtc() {
		return ModifiedUtc;
	}

	public void setModifiedUtc(OffsetDateTime modifiedUtc) {
		ModifiedUtc = modifiedUtc;
	}
		

}
