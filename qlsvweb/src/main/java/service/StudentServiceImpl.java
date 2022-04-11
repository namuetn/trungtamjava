package service;

import java.sql.SQLException;
import java.util.List;

import dao.PersonDAO;
import dao.StudentDAO;
import model.Student;

public class StudentServiceImpl implements StudentService {
	StudentDAO studentDAO = new StudentDAO();
	PersonDAO personDAO = new PersonDAO();

	@Override
	public void insert(Student student) throws SQLException {
		personDAO.add(student);
		studentDAO.add(student);
	}

	@Override
	public void delete(int id) throws SQLException {
		studentDAO.delete(id);
		personDAO.delete(id);
	}

	@Override
	public void update(Student student) throws SQLException {
		personDAO.update(student);
		studentDAO.update(student);
	}

	@Override
	public List<Student> getAll() throws SQLException {
		return studentDAO.selectAll();
	}

	@Override
	public List<Student> search(String name) throws SQLException {
		return studentDAO.search(name);
	}
}
