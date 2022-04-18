package com.kieuthanhnam.demospringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kieuthanhnam.demospringboot.dto.Course;

@Controller
@RequestMapping("/course")
public class CourseController {
	List<Course> list = new ArrayList<Course>();
	
	@GetMapping("/create")
	public String create() {
		return "course/create";
	}
	
	@PostMapping("/create")
	public String create(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
		list.add(new Course(Integer.parseInt(id), name));
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		req.setAttribute("msg", "Them1 thanh cong");
		
		return "course/create";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
		list.remove(new Course(Integer.parseInt(id), name));
		req.setAttribute("msg", "Xoa thanh cong");
		
		return "course/search";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("CourseList", list);
		return "course/search";
	}
}
