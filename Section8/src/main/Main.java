package main;

import model.Laptop;
import model.Student;

public class Main {

	public static void main(String[] args) {
		Student st1 = new Student();
		st1.input();
		Student st2 = new Student();
		st2.input();
		
		Laptop l1 = new Laptop();
		l1.input();
		Laptop l2 = new Laptop();
		l2.input();
		
		l1.setOwner(st1);
		l2.setOwner(st2);
		
		System.out.println("Info");
		l1.info();
		l1.getOwner().info();
		st1.info();
		System.out.println("Info 2");
		l2.getOwner().info();
		st2.info();
	}
}
