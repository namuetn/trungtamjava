package service;

import java.io.IOException;

public interface FileService {
	void writeFile() throws IOException;

	void readFile() throws IOException, ClassNotFoundException;

	void writeList() throws IOException, ClassNotFoundException;

	void readList() throws IOException, ClassNotFoundException;
}
