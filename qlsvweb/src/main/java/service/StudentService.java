package service;

import java.sql.SQLException;
import java.util.List;

import model.Student;

public interface StudentService {
	
	void insert(Student student) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	void update(Student student) throws SQLException;
	
	List<Student> getAll() throws SQLException;
	
	List<Student> search(String name) throws SQLException;
}
