package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private int id;
	private String username;
	private String password;
	private String fullname;
	CatUser catUser;
	
	public User(int id, String username, String password, String fullname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}

	public User(int id) {
		super();
		this.id = id;
	}

	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public User(String username, String password, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}

	public User(int id, String username, String fullname) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
	}

	public User(String username, String password, String fullname, CatUser catUser) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.catUser = catUser;
	}

	public User(int id, String password, String fullname, CatUser catUser) {
		super();
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.catUser = catUser;
	}

//	public User(int id, String username, String fullname, CatUser catUser) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.fullname = fullname;
//		this.catUser = catUser;
//	}
	
}
