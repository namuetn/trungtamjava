package service;

import java.sql.SQLException;
import java.util.List;

import model.MyClass;

public interface MyClassService {
	void insert(MyClass mc) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	void update(MyClass mc) throws SQLException;
	
	List<MyClass> getAll() throws SQLException;
}
