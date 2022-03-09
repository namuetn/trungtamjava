package com.trungtamjava.main;

import java.util.Scanner;

import com.trungtamjava.model.Animal;
import com.trungtamjava.model.Chicken;
import com.trungtamjava.model.Dog;

public class Main {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		while (true) {
			System.out.println("Chon lai dong vat");
			System.out.println("1. Dog");
			System.out.println("2. Chicken");
			
			int sc = new Scanner(System.in).nextInt();
			
			switch (sc) {
				case 1:
					menuDog();
					break;
				case 2:
					menuChicken();
					break;
				default:
					System.out.println("Vui long chon lai:");
					break;
			}
		}
	}
	
	public static void menuChicken() {
		System.out.println("Vui long so luong");
		int n = new Scanner(System.in).nextInt();
		
		Animal[] chickens = new Chicken[n];
		for (int i = 0; i < chickens.length; i++) {
			chickens[i] = new Chicken();
			input(chickens[i]);
		}
		
		for (Animal chicken : chickens) {
			info(chicken);
			System.out.println("-----------------");
		}
		
	}
	
	public static void menuDog() {
		System.out.println("Vui long so luong");
		int n = new Scanner(System.in).nextInt();
		
		Animal[] dogs = new Dog[n];
		for (int i = 0; i < dogs.length; i++) {
			dogs[i] = new Dog();
			input(dogs[i]);
		}
		
		for (Animal dog : dogs) {
			info(dog);
			System.out.println("-----------------");
		}
	}
	
	public static void input(Animal al) {
		System.out.println("Animal Input");
		System.out.println("Type:");
		al.setType(new Scanner(System.in).nextLine());
		System.out.println("Age:");
		al.setAge(new Scanner(System.in).nextInt());
		
		if (al instanceof Dog) {
			System.out.println("Dog Input");
			Dog d = (Dog) al;
			
			System.out.println("Color:");
			d.setColor(new Scanner(System.in).nextLine());
		}
		
		if (al instanceof Chicken) {
			System.out.println("Chicken Input");
			Chicken ck = (Chicken) al;
			ck.setFoot(2);
		}
	}
	
	public static void info(Animal al) {
		System.out.println("Animal Info");
		System.out.println(al.getType());
		System.out.println(al.getAge());
		
		if (al instanceof Dog) {
			System.out.println("Dog INFO");
			Dog d = (Dog) al;
			System.out.println(d.getColor());
		}
		
		if (al instanceof Chicken) {
			System.out.println("Chicken INFO");
			Chicken ck = (Chicken) al;
			System.out.println(ck.getFoot());
		}
	}
}
