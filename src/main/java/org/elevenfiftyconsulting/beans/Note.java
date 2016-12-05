package org.elevenfiftyconsulting.beans;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int Shopping_List_Item_Id;

	private String Body;
	private OffsetDateTime CreatedUtc;
	private OffsetDateTime ModifiedUtc;

	@Override
	public String toString() {
		return "Note [id=" + id + ", Shopping_List_Item_Id=" + Shopping_List_Item_Id + ", "
				+ (Body != null ? "Body=" + Body + ", " : "")
				+ (CreatedUtc != null ? "CreatedUtc=" + CreatedUtc + ", " : "")
				+ (ModifiedUtc != null ? "ModifiedUtc=" + ModifiedUtc : "") + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getShopping_List_Item_Id() {
		return Shopping_List_Item_Id;
	}

	public void setShopping_List_Item_Id(int shopping_List_Item_Id) {
		Shopping_List_Item_Id = shopping_List_Item_Id;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
