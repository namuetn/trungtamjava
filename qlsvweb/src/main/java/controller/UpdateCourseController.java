package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String idString = req.getParameter("id");
		String nameString = req.getParameter("name");
		
		pw.println("<form action=\"/qlsvweb/update-course\" method=\"post\">\r\n"
				+ "		<label for=\"fname\">ID:</label><br>\r\n"
				+ "	   	<input type=\"number\" id=\"fname\" name=\"id\" value='" + idString + "'><br>\r\n"
				+ "	  	<label for=\"lname\">Name:</label><br>\r\n"
				+ "	  	<input type=\"text\" id=\"lname\" name=\"name\" value='" + nameString + "'><br>\r\n"
				+ "	  	<button type=\"submit\">Update</button>\r\n"
				+ "	</form>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		try {
			String idString = req.getParameter("id");
			String nameString = req.getParameter("name");
			
			Course course = new Course();
			course.setId(Integer.parseInt(idString));
			course.setName(nameString);
			
			courseService.update(course);
			
			pw.println("<p>Cap nhap Thanh cong</p>");
		} catch (SQLException e) {
			pw.println("<p>Loi server</p>");
			e.printStackTrace();
		}
		
		pw.println("<a href='/qlsvweb/menu-course'>Quay lai</a>");
	}
}
