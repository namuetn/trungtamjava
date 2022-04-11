package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Person;
import model.Student;

public class StudentDAO {
	public void add(Student st) throws SQLException {
		String sql = "insert into students(person_id, code, sex) value (?, ?, ?)";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, st.getId());
		ps.setInt(2, st.getCode());
		ps.setString(3, st.getSex());
		
		ps.executeUpdate();
	}
	
	public void update(Student st) throws SQLException {
		String sql = "update students set code = ?, sex = ? where person_id = ?";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, st.getCode());
		ps.setString(2, st.getSex());
		ps.setInt(3, st.getId());
		
		ps.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from students where person_id = ?";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}
	
	public List<Student> selectAll() throws SQLException {
		String sql = "select person_id, name, birthdate, code, age, sex from students inner join person on students.person_id = person.id order by id desc";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Student> studentList = new ArrayList<Student>();
		
		while (rs.next()) {
			Student st = new Student();
			st.setId(rs.getInt("person_id"));
			st.setCode(rs.getInt("code"));
			st.setName(rs.getString("name"));
			st.setAge(rs.getInt("age"));
			st.setBirthdate(rs.getDate("birthdate"));
			st.setSex(rs.getString("sex"));
			
			studentList.add(st);
		}
		
		return studentList;
	}
	
	public List<Student> search(String name) throws SQLException {
		String sql = "select person_id, name, birthdate, code, age, sex from students inner join person on students.person_id = person.id where name like ? order by id desc";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		List<Student> studentList = new ArrayList<Student>();
		
		while (rs.next()) {
			Student st = new Student();
			
			st.setId(rs.getInt("person_id"));
			st.setCode(rs.getInt("code"));
			st.setName(rs.getString("name"));
			st.setAge(rs.getInt("age"));
			st.setBirthdate(rs.getDate("birthdate"));
			st.setSex(rs.getString("sex"));
			
			studentList.add(st);
		}
		
		return studentList;
	}
	
	public Student searchForStudentCode(int code) throws SQLException {
		String sql = "select person_id, name, birthdate, code, age, sex from students inner join person on students.person_id = person.id where code = ?";
		
		Connection conn =  JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, code);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Student st = new Student();
			
			st.setId(rs.getInt("person_id"));
			st.setCode(rs.getInt("code"));
			st.setName(rs.getString("name"));
			st.setAge(rs.getInt("age"));
			st.setBirthdate(rs.getDate("birthdate"));
			st.setSex(rs.getString("sex"));
			
			return st;
		}
		
		return null;
	}
}
