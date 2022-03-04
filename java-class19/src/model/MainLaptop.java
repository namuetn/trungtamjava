 package model;

import java.util.Scanner;

public class MainLaptop {

	public static void main(String[] args) {
//		Macbook macbook = new Macbook();
//		
//		macbook.setModel("Macbook");
//		macbook.setPrice(10000000);
//		
//		System.out.println(macbook.getModel());
		
//		macbook.input();
//		macbook.info();
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap so Laptop: ");
		Macbook[] mac = new Macbook[input.nextInt()];
		
		for (int i = 0; i < mac.length; i++) {
			mac[i] = new Macbook();
			mac[i].input();
		}
		
		for (int i = 0; i < mac.length; i++) {
			mac[i].info();
		}
		
		System.out.println("--------------");
		System.out.println("Sap xep san pham theo gia tang gian:");
		
		for (int i = 0; i < mac.length - 1; i++) {
			for (int j = i + 1; j < mac.length; j++) {
				if (mac[i].getPrice() > mac[j].getPrice()) {
					Macbook temp = mac[i];
					mac[i] = mac[j];
					mac[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < mac.length; i++) {
			mac[i].info();
		}
	}

}
