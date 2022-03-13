package main;

import model.Laptop;
import service.LaptopService;
import service.LaptopServiceImpl;

public class MainLaptop {

	public static void main(String[] args) {
		Laptop lt = new Laptop();
		LaptopService lts = new LaptopServiceImpl();
		
		while (true) {
			lts.input(lt);
			lts.infor(lt);
			System.out.println("hay nhap lai");
		}
	}

}
