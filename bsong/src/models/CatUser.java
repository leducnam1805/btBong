package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatUser {
	private int id;
	private String name;
	private boolean addquyen;
	private boolean editquyen;
	private boolean delquyen;
	public CatUser(String name) {
		super();
		this.name = name;
	}

	public CatUser(int id) {
		super();
		this.id = id;
	}

	public CatUser(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CatUser(int id, boolean addquyen, boolean editquyen, boolean delquyen) {
		super();
		this.id = id;
		this.addquyen = addquyen;
		this.editquyen = editquyen;
		this.delquyen = delquyen;
	}
}
