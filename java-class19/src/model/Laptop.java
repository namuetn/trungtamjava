package model;

import java.util.Scanner;

public class Laptop {
	private String model;
	private int price;
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void input() {
		System.out.println("Nhap model:");
		this.model = new Scanner(System.in).nextLine();
		
		System.out.println("Nhap price:");
		this.price = new Scanner(System.in).nextInt();
	}
	
	public void info() {
		System.out.println("-------------");
		System.out.println("Model:" + model);
		System.out.println("Price:" + price);
	}
}
