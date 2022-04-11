package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonDAO {
	public void add(Person p) throws SQLException {
		String sql = "insert into person(id, name, age, birthdate) value (?, ?, ?, ?)";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, p.getId());
		ps.setString(2, p.getName());
		ps.setInt(3, p.getAge());
		ps.setDate(4, new java.sql.Date(p.getBirthdate().getTime()));
		
		ps.executeUpdate();
	}
	
	public void update(Person p) throws SQLException {
		String sql = "update person set name = ?, age = ?, birthdate = ? where id = ?";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		ps.setString(1, p.getName());
		ps.setInt(2, p.getAge());
		ps.setDate(3, new java.sql.Date(p.getBirthdate().getTime()));
		ps.setInt(4, p.getId());
		
		ps.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from person where id = ?";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
												
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}
	
	public List<Person> selectAll() throws SQLException {
		String sql = "select id, name, age, birthdate from person order by id desc";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Person> personList = new ArrayList<Person>();
		
		while (rs.next()) {
			Person c = new Person();
			
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setAge(rs.getInt("age"));
			c.setBirthdate(rs.getDate("birthdate"));
			
			personList.add(c);
		}
		
		return personList;
	}
	
	public List<Person> search(String name) throws SQLException {
		String sql = "select id, name, age, birthdate from person where name like ? order by id desc";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		List<Person> personList = new ArrayList<Person>();
		
		while (rs.next()) {
			Person c = new Person();
			
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setAge(rs.getInt("age"));
			c.setBirthdate(rs.getDate("birthdate"));
			
			personList.add(c);
		}
		
		return personList;
	}
	
	public List<Person> search(int fromYear, int toYear) throws SQLException {
		String sql = "select id, name, age, birthdate from person where year(birthdate) >= ? and year(birthdate) <= ? order by id desc";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, fromYear);
		ps.setInt(2, toYear);
		
		ResultSet rs = ps.executeQuery();
		List<Person> personList = new ArrayList<Person>();
		
		while (rs.next()) {
			Person c = new Person();
			
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setAge(rs.getInt("age"));
			c.setBirthdate(rs.getDate("birthdate"));
			
			personList.add(c);
		}
		
		return personList;
	}
}
