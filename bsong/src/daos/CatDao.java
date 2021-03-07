package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Category;
import models.Songs;
import util.DBConnectionUtil;
import util.DefineUtil;

public class CatDao extends AbstractDAO {

	public java.util.List<Category> findAll() {
		java.util.List<Category> list = new ArrayList<Category>();
		con = DBConnectionUtil.getConnection();
		String sql = "select id,name from categories order by id desc";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Category objCat = new Category(rs.getInt("id"), rs.getString("name"));
				list.add(objCat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// xử lý chuyển sang trang mới
		}
		return list;
	}

	public int add(Category cat) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO categories(name) VALUES(?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, cat.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int del(int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "DELETE FROM categories WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Category edit(int id) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name FROM categories WHERE id = ?";
		Category objCat = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				objCat = new Category(rs.getInt("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objCat;
	}

	public int edit(Category cat) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE categories SET name = ? WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, cat.getName());
			pst.setInt(2, cat.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getCount() {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) AS count FROM categories";
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

	public List<Category> findAllAdmin(int offsetAdmin) {
		List<Category> itemsAdmin = new ArrayList<Category>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT *"
				+ " FROM categories"
				+ " ORDER BY id DESC LIMIT ?,?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offsetAdmin);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE_ADMIN);
			rs = pst.executeQuery();
			while(rs.next()) {
				Category objCat = new Category(rs.getInt("id"), rs.getString("name"));
				itemsAdmin.add(objCat);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemsAdmin;
	}

	public List<Category> search(String nameCat) {
		List<Category> searchList = new ArrayList<Category>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM categories"
				+ " WHERE name"
				+ " LIKE ?"
				+ " ORDER BY id DESC";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+nameCat+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				Category objCat = new Category(rs.getInt("id"), rs.getString("name"));
				searchList.add(objCat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}

	public int getCountCat() {
		int  countCat = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) AS count FROM categories";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				countCat = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countCat;
	}
}
