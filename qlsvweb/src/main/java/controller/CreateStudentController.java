package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

@WebServlet(urlPatterns = "/create-student")
public class CreateStudentController extends HttpServlet {
	StudentService studentService = new StudentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/createStudentForm.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/createStudentForm.jsp");
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String idString = req.getParameter("id");
			String nameString = req.getParameter("name");
			String ageString = req.getParameter("age");
			String birthDayString = req.getParameter("birthdate");
			String codeString = req.getParameter("code");
			String sexString = req.getParameter("sex");
			
			Student student = new Student();
			student.setId(Integer.parseInt(idString));
			student.setName(nameString);
			student.setAge(Integer.parseInt(ageString));
			student.setBirthdate(dateFormat.parse(birthDayString));
			student.setCode(Integer.parseInt(codeString));
			student.setSex(sexString);
			
			studentService.insert(student);
			
			req.setAttribute("msg", "Them thanh cong");
		} catch (SQLException e) {
			req.setAttribute("msg", "Loi server");
			
			e.printStackTrace();
		} catch (ParseException e) {
			req.setAttribute("msg", "Sai dinh dang ngay thang nam");
			e.printStackTrace();
		}
		
		dispatcher.forward(req, resp);
	}
}
