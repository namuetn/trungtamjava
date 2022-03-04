package model;

import java.util.Scanner;

public class Human {
	public String name;
	public int age;
	
	protected void info() {
		System.out.println("Class Human");
		System.out.println(name);
		System.out.println(age);
	}
	
	public void input() {
		System.out.println("Nhap ten:");
		this.name = new Scanner(System.in).nextLine();
		
		System.out.println("Nhap tuoi:");
		this.age = new Scanner(System.in).nextInt();
	}
}
