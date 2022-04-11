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

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

@WebServlet(urlPatterns = "/menu-student")
public class MenuStudentController extends HttpServlet {
	StudentService studentService = new StudentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/menuStudent.jsp");
		
		try {
			List<Student> students = studentService.getAll();
			req.setAttribute("students", students);
			
		} catch (SQLException e) {
			req.setAttribute("msg", "Xay ra loi DB");
			e.printStackTrace();
		}
		
		dispatcher.forward(req, resp);
	}
}
