package main;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

public class MainStudent {
	public static void main(String[] args) {
		Student st = new Student();
		StudentService sts = new StudentServiceImpl();
		
		while (true) {
			sts.input(st);
			sts.info(st);
			System.out.println("hay nhap lai");
		}
	}
}
