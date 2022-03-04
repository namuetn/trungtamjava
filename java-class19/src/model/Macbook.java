package model;

import java.util.Scanner;

public class Macbook extends Laptop {
	private String macOS;
	
	@Override
	public void input() {
		super.input();
		System.out.println("Nhap OS:");
		this.macOS = new Scanner(System.in).nextLine();
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println("OS:" + macOS);
	}

	public String getMacOS() {
		return macOS;
	}

	public void setMacOS(String macOS) {
		this.macOS = macOS;
	}
}
