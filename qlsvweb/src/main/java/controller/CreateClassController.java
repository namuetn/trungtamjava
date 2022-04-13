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
import model.MyClass;
import service.CourseService;
import service.CourserServiceImpl;
import service.MyClassService;
import service.MyClassServiceImpl;

@WebServlet(urlPatterns = "/create-class")
public class CreateClassController extends HttpServlet {
	CourseService courseService = new CourserServiceImpl();
	MyClassService myClassService = new MyClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/class/createClassForm.jsp");
		try {
			List<Course> courses = courseService.getAll();
			req.setAttribute("courses", courses);
		} catch (SQLException e) {
			req.setAttribute("msg", "Xay ra loi");
			e.printStackTrace();
		}
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/class/createClassForm.jsp");
		
		try {
			String idString = req.getParameter("id");
			String nameString = req.getParameter("name");
			String courseId = req.getParameter("course_id");
			
			List<Course> courses = courseService.getAll();
			req.setAttribute("courses", courses);
			
			Course course = new Course();
			course.setId(Integer.parseInt(courseId));
			
			MyClass myClass = new MyClass();
			myClass.setId(Integer.parseInt(idString));
			myClass.setName(nameString);
			myClass.setCourse(course);
			
			myClassService.insert(myClass);
			
			req.setAttribute("msg", "Them thanh cong");
		} catch (SQLException e) {
			req.setAttribute("msg", "Loi server");
			
			e.printStackTrace();
		}
		
		dispatcher.forward(req, resp);
	}
}
