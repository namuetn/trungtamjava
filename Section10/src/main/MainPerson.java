package main;

import java.util.Scanner;

import model.Boss;
import model.Employee;

public class MainPerson {

	public static void main(String[] args) {
		while (true) {
			System.out.println("Select option");
			System.out.println("1. Employee");
			System.out.println("2. Boss");
			int sc = new Scanner(System.in).nextInt();
			
			switch (sc) {
				case 1:
					Employee e = new Employee();
					e.salary();
					
					break;
				case 2:
					Boss b = new Boss();
					System.out.println("Nhap so tien cua boss");
					b.setPrice(new Scanner(System.in).nextInt());
					b.salary();
					break;
		
				default:
					System.out.println("Vui long chon lai");
					break;
			}
		}
	}
}
