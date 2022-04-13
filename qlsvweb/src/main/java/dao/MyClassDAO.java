package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.MyClass;

public class MyClassDAO {
	public void add(MyClass c) throws SQLException {
		String sql = "insert into class(id, name, course_id) value (?, ?, ?)";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		ps.setInt(3, c.getCourse().getId());
		
		ps.executeUpdate();
	}
	
	public void update(MyClass c) throws SQLException {
		String sql = "update class set name = ?, course_id = ? where id = ?";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, c.getName());
		ps.setInt(2, c.getCourse().getId());
		ps.setInt(3, c.getId());
		
		ps.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from class where id = ?";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}
	
	public List<MyClass> selectAll() throws SQLException {
		String sql = "select class.id, class.name, courses.name as course_name from class inner join courses on class.course_id = courses.id order by id desc";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<MyClass> list = new ArrayList<MyClass>();
		
		while (rs.next()) {
			MyClass c = new MyClass();
			c.setId(rs.getInt("class.id"));
			c.setName(rs.getString("class.name"));
			Course course = new Course();
			course.setName(rs.getString("course_name"));
			c.setCourse(course);
			
			
			list.add(c);
		}
		
		return list;
	}
}
