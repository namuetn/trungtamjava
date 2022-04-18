package com.kieuthanhnam.demospringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kieuthanhnam.demospringboot.dto.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	List<Student> list = new ArrayList<Student>();
	
	@GetMapping("/create")
	public String create() {
		return "student/create";
	}
	
	@PostMapping("/create")
	public String create(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
		list.add(new Student(Integer.parseInt(id), name));
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		req.setAttribute("msg", "Them1 thanh cong");
		
		return "student/create";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
		list.remove(new Student(Integer.parseInt(id), name));
		req.setAttribute("msg", "Xoa thanh cong");
		
		return "student/search";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("StudentList", list);
		return "student/search";
	}
}
