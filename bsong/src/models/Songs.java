package models;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Songs {
	private int id;
	private String name;
	private String description;
	private String detail;
	private String picture;
	private int counter;
	private Timestamp CreatedAt;
	private Category cat;
	
	public Songs(int id, String name, String description, String detail, String picture, int counter,
			Timestamp createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.picture = picture;
		this.counter = counter;
		CreatedAt = createdAt;
	}

	public Songs(String name, String description, String detail, String picture, Category cat) {
		super();
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.picture = picture;
		this.cat = cat;
	}

	public Songs(int id, String name, String description, String detail, String picture, Category cat) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.picture = picture;
		this.cat = cat;
	}

	public Songs(String name, Category cat) {
		super();
		this.name = name;
		this.cat = cat;
	}
	
}
