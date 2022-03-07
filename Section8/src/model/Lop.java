package model;

import java.util.Scanner;

public class Lop {
	private String tenLop;
	private int soLuongSv;
	
	private MonHoc monHoc;
	
	private Student[] students;
	
	public void input() {
		System.out.println("Nhap lop:");
		this.tenLop = new Scanner(System.in).nextLine();
		
		System.out.println("Nhap so luong:");
		this.soLuongSv = new Scanner(System.in).nextInt();
	}
	
	public void info() {
		System.out.println("-------------");
		System.out.println("Ten Lop:" + tenLop);
		System.out.println("So Luong:" + soLuongSv);
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getSoLuongSv() {
		return soLuongSv;
	}

	public void setSoLuongSv(int soLuongSv) {
		this.soLuongSv = soLuongSv;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}
}
