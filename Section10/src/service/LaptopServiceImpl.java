package service;

import java.util.Scanner;

import model.Laptop;

public class LaptopServiceImpl implements LaptopService {

	@Override
	public void input(Laptop lt) {
		System.out.println("Laptop Input");
		System.out.println("ID: ");
		lt.setId(new Scanner(System.in).nextInt());
		System.out.println("Cpu: ");
		lt.setCpu(new Scanner(System.in).nextLine());
		System.out.println("Ram: ");
		lt.setRam(new Scanner(System.in).nextInt());
		System.out.println("Vga: ");
		lt.setVga(new Scanner(System.in).nextLine());
	}

	@Override
	public void infor(Laptop lt) {
		System.out.println("Laptop Infor");
		System.out.println("ID: " + lt.getId());
		System.out.println("Cpu: " + lt.getCpu());
		System.out.println("Ram: " + lt.getRam());
		System.out.println("Vga: " + lt.getVga());
	}

}
