package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Product;

public class FileServiceImpl implements FileService {

	@Override
	public void writeFile() throws IOException {
		ProductService productService = new ProductServiceImpl();
		Product p = new Product();
		productService.input(p);

		File file = new File("text.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(p);

		objectOutputStream.close();
		fileOutputStream.close();

	}

	@Override
	public void readFile() throws IOException, ClassNotFoundException {
		ProductService productService = new ProductServiceImpl();

		File file = new File("text.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		Product p = (Product) objectInputStream.readObject();
		productService.info(p);

		fileInputStream.close();
		objectInputStream.close();

	}

	@Override
	public void writeList() throws IOException {
		ProductService productService = new ProductServiceImpl();

		File file = new File("list.txt");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		Product[] list = productService.inputList();
		objectOutputStream.writeObject(list);

		fileOutputStream.close();
		objectOutputStream.close();

	}

	@Override
	public void readList() throws IOException, ClassNotFoundException {
		ProductService productService = new ProductServiceImpl();

		File file = new File("list.txt");

		if (file.exists()) {

			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			Product[] list = (Product[]) objectInputStream.readObject();
			productService.infoList(list);

			objectInputStream.close();
			fileInputStream.close();
		}
	}

}