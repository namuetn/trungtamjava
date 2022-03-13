package service;

import java.util.Scanner;

import model.School;

public class SchoolServiceImpl implements SchoolService {

	@Override
	public void input(School sl) {
		System.out.println("School Input");
		System.out.println("ID: ");
		sl.setId(new Scanner(System.in).nextInt());
		System.out.println("School: ");
		sl.setName(new Scanner(System.in).nextLine());
	}

	@Override
	public void info(School sl) {
		System.out.println("School Infor");
		System.out.println("ID: " + sl.getId());
		System.out.println("Name: " + sl.getName());
		System.out.println("------------------------------");
	}
}
