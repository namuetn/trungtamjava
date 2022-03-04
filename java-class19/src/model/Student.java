package model;

import java.util.Scanner;

public class Student extends Human {
	private String studentClass;
	
	@Override
	public void info() {
		System.out.println("Class Student");
		super.info();
		System.out.println(this.studentClass);
		System.out.println(this.name);
	}
	
	@Override
	public void input() {
		super.input();
		
		System.out.println("Nhap lop hoc:");
		this.studentClass = new Scanner(System.in).nextLine();
	}
}
