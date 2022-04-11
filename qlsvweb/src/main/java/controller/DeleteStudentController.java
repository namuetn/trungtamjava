package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;
import service.StudentServiceImpl;

@WebServlet(urlPatterns = "/delete-student")
public class DeleteStudentController extends HttpServlet {
	StudentService studentService = new StudentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String idString = req.getParameter("id");
		try {
			studentService.delete(Integer.parseInt(idString));
			pw.println("<p>Xoa thanh cong</p>");
		} catch (NumberFormatException e) {
			pw.println("<p>Sai du lieu</p>");
			e.printStackTrace();
		} catch (SQLException e) {
			pw.println("<p>Loi server</p>");
			e.printStackTrace();
		}
		
		pw.println("<a href='/qlsvweb/menu-course'>Quay lai</a>");
	}
}
