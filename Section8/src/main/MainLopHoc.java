package main;

import java.util.Iterator;

import model.Lop;
import model.MonHoc;

public class MainLopHoc {
	public static void main(String[] args) {
		MonHoc cnpm = new MonHoc();
		cnpm.setTenMonHoc("Cong Nghe Phan Mem");
		
		Lop[] danhSachLop = new Lop[5];
		
		for (int i = 0; i < danhSachLop.length; i++) {
			danhSachLop[i] = new Lop();
			danhSachLop[i].input();
			
			danhSachLop[i].setMonHoc(cnpm);
		}
		
		System.out.println("Info class");
		for (int i = 0; i < danhSachLop.length; i++) {
			danhSachLop[i].info();
			System.out.println(danhSachLop[i].getMonHoc().getTenMonHoc());
		}
	}
}
