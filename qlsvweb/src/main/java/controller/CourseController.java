package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import service.CourseService;
import service.CourserServiceImpl;

@WebServlet(urlPatterns = "/menu-course")
public class CourseController extends HttpServlet {
	CourseService courseService = new CourserServiceImpl();
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init project");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/course/menuCourse.jsp");
		
		try {
			List<Course> courses = courseService.getAll();
			req.setAttribute("courses", courses);
			
		} catch (SQLException e) {
			req.setAttribute("msg", "Xay ra loi");
			e.printStackTrace();
		}
		
		dispatcher.forward(req, resp);
	}
}
