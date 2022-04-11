package service;

import java.sql.SQLException;
import java.util.List;

import model.Course;

public interface CourseService {
	void insert(Course course) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	void update(Course course) throws SQLException;
	
	List<Course> getAll() throws SQLException;
}
