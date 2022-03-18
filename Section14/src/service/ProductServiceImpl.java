package service;

import java.util.Scanner;

import model.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public void input(Product product) {
		System.out.println("Enter ID:");
		Scanner scan = new Scanner(System.in);
		product.setId(scan.nextInt());

		System.out.println("Enter Name:");
		scan = new Scanner(System.in);
		product.setName(scan.next());

		System.out.println("Enter Price:");
		scan = new Scanner(System.in);
		product.setPrice(scan.nextDouble());

	}

	@Override
	public void info(Product product) {
		System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
	}

	@Override
	public Product[] inputList() {
		System.out.println("Enter SL product:");
		Scanner scan = new Scanner(System.in);

		Product[] products = new Product[scan.nextInt()];

		for (int i = 0; i < products.length; i++) {
			products[i] = new Product();
			this.input(products[i]);
		}

		return products;

	}

	@Override
	public void infoList(Product[] products) {
		for (Product product : products) {
			this.info(product);
		}
	}

	@Override
	public Product[] inputList(Product[] list) {
		// TODO Auto-generated method stub
		return null;
	}

}