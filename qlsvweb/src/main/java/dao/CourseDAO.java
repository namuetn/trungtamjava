package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseDAO {
	public void add(Course c) throws SQLException {
		String sql = "insert into courses(id, name) value (?, ?)";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		
		ps.executeUpdate();
	}
	
	public void update(Course c) throws SQLException {
		String sql = "update courses set name = ? where id = ?";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, c.getName());
		ps.setInt(2, c.getId());
		
		ps.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from courses where id = ?";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}
	
	public List<Course> selectAll() throws SQLException {
		String sql = "select id, name from courses order by id desc";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Course> courList = new ArrayList<Course>();
		
		while (rs.next()) {
			Course c = new Course();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			
			courList.add(c);
		}
		
		return courList;
	}
}
