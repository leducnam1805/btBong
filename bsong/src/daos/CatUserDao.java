package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CatUser;
import util.DBConnectionUtil;

public class CatUserDao extends AbstractDAO {

	public List<CatUser> findAll() {
		List<CatUser> catUserList = new ArrayList<CatUser>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM categoriesuser ORDER BY id DESC";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				CatUser objCatUser = new CatUser(rs.getInt("id"), rs.getString("name"));
				catUserList.add(objCatUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catUserList;
	}

	public int getCount() {
		int count = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM categoriesuser";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int add(CatUser catUser) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO categoriesuser(name) VALUES(?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, catUser.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public CatUser findUsername(String name) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM categoriesuser WHERE name = ?";
		CatUser objCatUser = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next()) {
				objCatUser = new CatUser(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objCatUser;
	}

	public CatUser viewsEedit(int id) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM categoriesuser WHERE id = ?";
		CatUser objUserViews = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				objUserViews = new CatUser(rs.getInt("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUserViews;
	}

	public CatUser checkEdit(int id,String name) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM categoriesuser WHERE name = ? AND id != ?";
		CatUser objCatUser = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				objCatUser = new CatUser(rs.getInt("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return objCatUser;
	}
	
	public int edit(CatUser catUser) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE categoriesuser SET name = ? WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, catUser.getName());
			pst.setInt(2, catUser.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int del(int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "DELETE FROM categoriesuser WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<CatUser> findAllQuyen() {
		List<CatUser> phanQuyenList = new ArrayList<CatUser>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT * FROM categoriesuser ORDER BY id DESC";
		CatUser objPhanQuyen = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				objPhanQuyen= new CatUser(rs.getInt("id"),
						rs.getString("name"),
						rs.getBoolean("addquyen"),
						rs.getBoolean("editquyen"),
						rs.getBoolean("delquyen"));
				phanQuyenList.add(objPhanQuyen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phanQuyenList;
	}

	public int addquyen(CatUser catUser) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE categoriesuser SET addquyen = ? WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setBoolean(1, catUser.isAddquyen());
			pst.setInt(2, catUser.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int editquyen(CatUser catUser) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE categoriesuser SET editquyen = ? WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setBoolean(1, catUser.isEditquyen());
			pst.setInt(2, catUser.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delquyen(CatUser catUser) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE categoriesuser SET delquyen = ? WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setBoolean(1, catUser.isDelquyen());
			pst.setInt(2, catUser.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
