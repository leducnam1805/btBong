package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Category;
import models.Contact;
import models.Songs;
import models.User;
import util.DBConnectionUtil;
import util.DefineUtil;

public class ContactDao extends AbstractDAO{

	public List<Contact> findAll() {
		List<Contact> list = new ArrayList<Contact>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,email,website,message FROM contacts ORDER BY id DESC";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Contact objContacts = new Contact(rs.getInt("id"), rs.getString("name"), 
						rs.getString("website"), rs.getString("message"), rs.getString("email"));
				list.add(objContacts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int add(Contact contact) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO contacts(name,email,website,message) VALUES(?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getEmail());
			pst.setString(3, contact.getWebsite());
			pst.setString(4, contact.getContent());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int del(int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "DELETE FROM contacts WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getCount() {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) AS count FROM contacts";
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

	public List<Contact> findAllAdmin(int offsetAdmin) {
		List<Contact> contactListAdmin = new ArrayList<Contact>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT *"
				+ " FROM contacts"
				+ " ORDER BY id DESC LIMIT ?,?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offsetAdmin);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE_ADMIN);
			rs = pst.executeQuery();
			while(rs.next()) {
				Contact objContacts = new Contact(rs.getInt("id"), rs.getString("name"), 
						rs.getString("website"), rs.getString("message"), rs.getString("email"));
				contactListAdmin.add(objContacts);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactListAdmin;
	}

	public List<Contact> search(String nameContact) {
		List<Contact> searchList = new ArrayList<Contact>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM contacts"
				+ " WHERE name"
				+ " LIKE ?"
				+ " ORDER BY id DESC";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+nameContact+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				Contact objContacts = new Contact(rs.getInt("id"), rs.getString("name"), 
						rs.getString("website"), rs.getString("message"), rs.getString("email"));
				searchList.add(objContacts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}
}