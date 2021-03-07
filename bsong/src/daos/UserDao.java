package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CatUser;
import models.Category;
import models.Songs;
import models.User;
import util.DBConnectionUtil;
import util.DefineUtil;

public class UserDao extends AbstractDAO{

//	public List<User> findAll(){
//		List<User> list = new ArrayList<User>();
//		con = DBConnectionUtil.getConnection();
//		String sql = "SELECT id,username,fullname FROM users ORDER BY id DESC";
//		try {
//			st= con.createStatement();
//			rs = st.executeQuery(sql);
//			while(rs.next()) {
//				User objUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"));
//				list.add(objUser);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

	public int add(User user) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO users(username,password,fullname,cat_user) VALUES(?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			pst.setInt(4, user.getCatUser().getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public User viewsEdit(int id) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT users.*,cu.id AS cuid,cu.name AS cuname FROM users"
				+ " INNER JOIN categoriesuser AS cu"
				+ " ON users.cat_user = cu.id"
				+ " WHERE users.id = ?";
		User objUser = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				objUser = new User(rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("fullname"), 
						new CatUser(rs.getInt("cat_user"), rs.getString("cuname")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUser;
	}

	public int edit(User userEdit) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE users SET password = ?,fullname = ?,cat_user = ? WHERE  id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userEdit.getPassword());
			pst.setString(2, userEdit.getFullname());
			pst.setInt(3, userEdit.getCatUser().getId());
			pst.setInt(4, userEdit.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int del(int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "DELETE FROM users WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public User findUsernameANDPass(String username,String password) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		User objUser = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				objUser = new User(rs.getInt("id"),
						rs.getString("username"), 
						rs.getString("password"),
						rs.getString("fullname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUser;
	}

	public int getCount() {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) AS count FROM users";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<User> findAllAdmin(int offsetAdmin) {
		List<User> itemsAdmin = new ArrayList<User>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT users.*,cu.id AS cuid,cu.name AS cuname"
				+ " FROM users"
				+ " INNER JOIN categoriesuser AS cu"
				+ " ON users.cat_user = cu.id"
				+ " ORDER BY id DESC LIMIT ?,?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offsetAdmin);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE_ADMIN);
			rs = pst.executeQuery();
			while(rs.next()) {
				User objUser = new User(rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("fullname"),
						new CatUser(rs.getInt("cat_user"), rs.getString("cuname")));
				itemsAdmin.add(objUser);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemsAdmin;
	}

	public List<User> search(String nameUser) {
		List<User> searchList = new ArrayList<User>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM users"
				+ " WHERE username"
				+ " LIKE ?"
				+ " ORDER BY id DESC";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+nameUser+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				User objUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"));
				searchList.add(objUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}

	public int getcountUser() {
		int  countUser = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) AS count FROM users";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				countUser = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countUser;
	}

	public User findUsername(String username) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM users WHERE username = ?";
		User objUser = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if(rs.next()) {
				objUser = new User(rs.getInt("id"),
						rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUser;
	}

	public User viewAll(String username) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT c.*,cu.id AS cuid,cu.name,cu.addquyen,cu.editquyen,cu.delquyen FROM users AS c "
				+ " INNER JOIN categoriesuser AS cu "
				+ " ON c.cat_user = cu.id "
				+ " WHERE username = ?";
		User objUser = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if(rs.next()) {
				objUser = new User(rs.getInt("id"), 
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("fullname"), 
						new CatUser(rs.getInt("cuid"),
								rs.getString("name"), 
								rs.getBoolean("addquyen"),
								rs.getBoolean("editquyen"),
								rs.getBoolean("delquyen")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUser;
	}
}
