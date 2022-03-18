package service;

import model.Product;

public interface ProductService {
	void input(Product p);
	
	void info(Product p);
	
	void infoList(Product[] list);
	
	Product[] inputList(Product[] list);
}
