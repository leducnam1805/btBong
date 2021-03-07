package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDAO {
	
	protected Statement st;
	
	protected PreparedStatement pst;
	
	protected Connection con;
	
	protected ResultSet rs;
	
}
