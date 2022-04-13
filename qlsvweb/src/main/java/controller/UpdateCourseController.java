package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import service.CourseService;
import service.CourserServiceImpl;

@WebServlet(urlPatterns = "/update-course")
public class UpdateCourseController extends HttpServlet {
CourseService courseService = new CourserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/course/updateCourseForm.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/course/updateCourseForm.jsp");
		
		try {
			String idString = req.getParameter("id");
			String nameString = req.getParameter("name");
			
			Course course = new Course();
			course.setId(Integer.parseInt(idString));
			course.setName(nameString);
			
			courseService.insert(course);
			
			req.setAttribute("msg", "Cap nhap thanh cong");
		} catch (SQLException e) {
			req.setAttribute("msg", "Loi server");
			
			e.printStackTrace();
		}
		
		dispatcher.forward(req, resp);
	}
}
