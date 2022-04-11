package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CourseDAO;
import model.Course;

public class CourserServiceImpl implements CourseService {
	CourseDAO dao = new CourseDAO();
	
	@Override
	public void insert(Course course) throws SQLException {
		dao.add(course);
	}

	@Override
	public void delete(int id) throws SQLException {
		dao.delete(id);
	}

	@Override
	public void update(Course course) throws SQLException {
		dao.update(course);
	}

	@Override
	public List<Course> getAll() throws SQLException {
		return dao.selectAll();
	}
}
