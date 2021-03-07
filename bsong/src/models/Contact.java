package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	private int id;
	private String name;
	private String website;
	private String content;
	private String email;
	
	public Contact(String name, String website, String content, String email) {
		super();
		this.name = name;
		this.website = website;
		this.content = content;
		this.email = email;
	}

	public Contact(int id) {
		super();
		this.id = id;
	}
	
	
}
