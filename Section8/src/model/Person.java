package model;

import java.util.Scanner;

public class Person {
	private int age;
	private String name;
	
	public Person() {
		
	}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void input() {
		System.out.println("Nhap ten:");
		this.name = new Scanner(System.in).nextLine();
		
		System.out.println("Nhap tuoi:");
		this.age = new Scanner(System.in).nextInt();
	}
	
	public void info() {
		System.out.println("-------------");
		System.out.println("Name:" + name);
		System.out.println("Age:" + age);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
