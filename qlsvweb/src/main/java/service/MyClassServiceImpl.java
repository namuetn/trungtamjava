package service;

import java.sql.SQLException;
import java.util.List;

import dao.MyClassDAO;
import model.MyClass;

public class MyClassServiceImpl implements MyClassService {
	MyClassDAO dao = new MyClassDAO();
	
	@Override
	public void insert(MyClass mc) throws SQLException {
		dao.add(mc);
	}

	@Override
	public void delete(int id) throws SQLException {
		dao.delete(id);
	}

	@Override
	public void update(MyClass mc) throws SQLException {
		dao.update(mc);
	}

	@Override
	public List<MyClass> getAll() throws SQLException {
		return dao.selectAll();
	}
}
