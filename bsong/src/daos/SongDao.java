package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constants.GlobalConstants;
import models.Category;
import models.Contact;
import models.Songs;
import util.DBConnectionUtil;
import util.DefineUtil;

public class SongDao extends AbstractDAO {
	public List<Songs> findAll() {
		List<Songs> list = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT songs.*,categories.name AS catName FROM songs "
				+ "INNER JOIN categories "
				+ "ON songs.cat_id = categories.id "
				+ "ORDER BY songs.id DESC";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("preview_text"), 
						rs.getString("detail_text"),
						rs.getString("picture"), 
						rs.getInt("counter"), 
						rs.getTimestamp("date_create"),
						new Category(rs.getInt("cat_id"), rs.getString("catName")));
				list.add(objSong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Songs viewsAll(int id) {
		Songs objSong  = null;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT songs.*,categories.id,categories.name FROM songs "
				+ "INNER JOIN categories "
				+"ON songs.cat_id = categories.id "
				+ "WHERE songs.id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				objSong = new Songs(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("preview_text"), 
						rs.getString("detail_text"),
						rs.getString("picture"),
						rs.getInt("counter"),
						rs.getTimestamp("date_create"),
						new Category(rs.getInt("cat_id"), rs.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objSong;
	}

	public List<Songs> relateSong(Songs songList) {
		List<Songs> songRelate = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT songs.*,categories.id,categories.name FROM songs "
				+ "INNER JOIN categories "
				+"ON songs.cat_id = categories.id "
				+ "WHERE songs.cat_id = ? AND songs.id != ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, songList.getCat().getId());
			pst.setInt(2, songList.getId());
			rs = pst.executeQuery();
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"), 
						rs.getString("name"),
						rs.getString("preview_text"),
						rs.getString("detail_text"),
						rs.getString("picture"), 
						rs.getInt("counter"),
						rs.getTimestamp("date_create"),
						new Category(rs.getInt("cat_id"), rs.getString("name")));
				songRelate.add(objSong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songRelate;
	}

	public List<Songs> viewIdCat(int id) {
		List<Songs> songList = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT songs.*,categories.id,categories.name FROM songs "
				+ "INNER JOIN categories "
				+ "ON songs.cat_id = categories.id "
				+ "WHERE categories.id = ? "
				+ "ORDER BY songs.id DESC";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("preview_text"),
						rs.getString("detail_text"),
						rs.getString("picture"), 
						rs.getInt("counter"),
						rs.getTimestamp("date_create"),
						new Category(rs.getInt("cat_id"), rs.getString("name")));
				songList.add(objSong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songList;
	}

	public List<Songs> findLatest() {
		List<Songs> songListFL = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT songs.* FROM songs "
				+ "ORDER BY songs.id DESC "
				+ "LIMIT 5";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"), 
						rs.getString("name"),
						rs.getString("preview_text"), 
						rs.getString("detail_text"),
						rs.getString("picture"),
						rs.getInt("counter"), 
						rs.getTimestamp("date_create"));
				songListFL.add(objSong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songListFL;
	}

	public int add(Songs song) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO songs(name,preview_text,detail_text,picture,cat_id) VALUES(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, song.getName());
			pst.setString(2, song.getDescription());
			pst.setString(3, song.getDetail());
			pst.setString(4, song.getPicture());
			pst.setInt(5, song.getCat().getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Songs viewsEdit(int id) {
		Songs objSong = null;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT s.id,s.name,preview_text,detail_text,picture,cat_id,c.id AS cid,c.name AS cname "
				+ "FROM songs AS s "
				+ "INNER JOIN categories AS c "
				+ "ON s.cat_id = c.id "
				+ "WHERE s.id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				objSong = new Songs(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("preview_text"),
						rs.getString("detail_text"),
						rs.getString("picture"),
						new Category(rs.getInt("cid"), rs.getString("cname")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return objSong;
	}

	public int edit(Songs song) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE songs "
				+ "SET name = ?, preview_text = ?,detail_text = ?,picture = ?, cat_id = ? "
				+ "WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, song.getName());
			pst.setString(2, song.getDescription());
			pst.setString(3, song.getDetail());
			pst.setString(4, song.getPicture());
			pst.setInt(5, song.getCat().getId());
			pst.setInt(6, song.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int del(int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "DELETE FROM songs WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int numberOfItems(int catId) {
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) AS count FROM songs WHERE cat_id = ?";
		int count = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, catId);
			rs = pst.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Songs> viewIdCatPagination(int offset, int catId) {
		List<Songs> items = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT s.*,c.id AS cid,c.name AS cname"
				+ " FROM songs AS s"
				+ " INNER JOIN categories AS c ON s.cat_id = c.id"
				+ " WHERE cat_id = ?"
				+ " ORDER BY s.id DESC LIMIT ?,?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, catId);
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("preview_text"), 
						rs.getString("detail_text"), 
						rs.getString("picture"), 
						rs.getInt("counter"), 
						rs.getTimestamp("date_create"), 
						new Category(rs.getInt("cat_id"), rs.getString("cname")));
				items.add(objSong);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	public int getCount() {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) AS count FROM songs";
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

	public List<Songs> findAll(int offset) {
		List<Songs> itemsIndex = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT s.*,c.id AS cid,c.name AS cname"
				+ " FROM songs AS s"
				+ " INNER JOIN categories AS c ON s.cat_id = c.id"
				+ " ORDER BY s.id DESC LIMIT ?,?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE_INDEX);
			rs = pst.executeQuery();
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("preview_text"), 
						rs.getString("detail_text"), 
						rs.getString("picture"), 
						rs.getInt("counter"), 
						rs.getTimestamp("date_create"), 
						new Category(rs.getInt("cat_id"), rs.getString("cname")));
				itemsIndex.add(objSong);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemsIndex;
	}
	// phân trang song admin
	public List<Songs> findAllAdmin(int offsetAdmin) {
		List<Songs> itemsAdmin = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT s.*,c.id AS cid,c.name AS cname"
				+ " FROM songs AS s"
				+ " INNER JOIN categories AS c ON s.cat_id = c.id"
				+ " ORDER BY s.id DESC LIMIT ?,?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offsetAdmin);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE_ADMIN);
			rs = pst.executeQuery();
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("preview_text"), 
						rs.getString("detail_text"), 
						rs.getString("picture"), 
						rs.getInt("counter"), 
						rs.getTimestamp("date_create"), 
						new Category(rs.getInt("cat_id"), rs.getString("cname")));
				itemsAdmin.add(objSong);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemsAdmin;
	}

	public List<Songs> search(String nameSong) {
		List<Songs> searchList = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT songs.*,categories.name AS catName FROM songs"
				+ " INNER JOIN categories"
				+ " ON songs.cat_id = categories.id"
				+ " WHERE songs.name"
				+ " LIKE ?"
				+ " ORDER BY songs.id DESC";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+nameSong+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("preview_text"), 
						rs.getString("detail_text"),
						rs.getString("picture"), 
						rs.getInt("counter"), 
						rs.getTimestamp("date_create"),
						new Category(rs.getInt("cat_id"), rs.getString("catName")));
				searchList.add(objSong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}

	public int countId(int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE songs SET counter = counter + 1 WHERE id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getCountSong() {
		int  countSong = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) AS count FROM songs";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				countSong = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countSong;
	}

	public List<Songs> searchPage(String editbox_search, int searchOffset) {
		List<Songs> searchItemsAdmin = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT s.*,c.id AS cid,c.name AS cname"
				+ " FROM songs AS s"
				+ " INNER JOIN categories AS c ON s.cat_id = c.id"
				+ " WHERE s.name"
				+ " LIKE ?"
				+ " ORDER BY s.id DESC LIMIT ?,?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+editbox_search+"%");
			pst.setInt(2, searchOffset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE_INDEX);
			rs = pst.executeQuery();
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("preview_text"), 
						rs.getString("detail_text"), 
						rs.getString("picture"), 
						rs.getInt("counter"), 
						rs.getTimestamp("date_create"), 
						new Category(rs.getInt("cat_id"), rs.getString("cname")));
				searchItemsAdmin.add(objSong);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchItemsAdmin;
	}

	public int getCountSearch(String editbox_search) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM songs AS s"
				+ " WHERE s.name"
				+ " LIKE ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+editbox_search+"%");
			rs = pst.executeQuery();
			if(rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Songs> searchCatSong(int searchloc) {
		List<Songs> searchCatSongList = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT s.*,c.id AS cid,c.name AS cname"
				+ " FROM songs AS s"
				+ " INNER JOIN categories AS c ON s.cat_id = c.id"
				+ " WHERE cat_id"
				+ " LIKE ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, searchloc);
			rs = pst.executeQuery();
			while(rs.next()) {
				Songs objSearchCatSongList = new Songs(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("preview_text"), 
						rs.getString("detail_text"), 
						rs.getString("picture"), 
						rs.getInt("counter"), 
						rs.getTimestamp("date_create"), 
						new Category(rs.getInt("cat_id"), rs.getString("cname")));
				searchCatSongList.add(objSearchCatSongList);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchCatSongList;
	}

	public List<Songs> searchLocInput(Songs song) {
		List<Songs> searchLocInput = new ArrayList<Songs>();
		con = DBConnectionUtil.getConnection();
		String sql = "SELECT s.*,c.id AS cid,c.name AS cname"
				+ " FROM songs AS s"
				+ " INNER JOIN categories AS c ON s.cat_id = c.id"
				+ " WHERE cat_id = ? AND s.name"
				+ " LIKE ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, song.getCat().getId());
			pst.setString(2, "%"+song.getName()+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				Songs objSong = new Songs(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("preview_text"), 
						rs.getString("detail_text"), 
						rs.getString("picture"), 
						rs.getInt("counter"), 
						rs.getTimestamp("date_create"), 
						new Category(rs.getInt("cat_id"), rs.getString("cname")));
				searchLocInput.add(objSong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchLocInput;
	}

}