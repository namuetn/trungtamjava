package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyClass;
import service.MyClassService;
import service.MyClassServiceImpl;

@WebServlet(urlPatterns = "/menu-class")
public class MenuClassController extends HttpServlet {
	MyClassService myClassService = new MyClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/class/menuClass.jsp");
		
		try {
			List<MyClass> classes = myClassService.getAll();
			req.setAttribute("classes", classes);
			
		} catch (SQLException e) {
			req.setAttribute("msg", "Xay ra loi DB");
			e.printStackTrace();
		}
		
		dispatcher.forward(req, resp);
	}
}
