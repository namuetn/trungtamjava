package service;

import java.util.Scanner;

import model.Address;
import model.School;
import model.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public void input(Student st) {
		System.out.println("Student Input");
		System.out.println("ID: ");
		st.setId(new Scanner(System.in).nextInt());
		System.out.println("Name: ");
		st.setName(new Scanner(System.in).nextLine());
		System.out.println("Age: ");
		st.setAge(new Scanner(System.in).nextInt());
		
		School sl = new School();
		SchoolService sls = new SchoolServiceImpl();
		sls.input(sl);
		st.setSchool(sl);
		
		Address ad = new Address();
		AddressService ads = new AddressSerivceImpl();
		ads.input(ad);
		st.setAddress(ad);
		
//		School sc = new School();
//		SchoolService schoolService = new SchoolServiceImpl();
//		schoolService.input(sc);
//		st.setSchool(sc);
//
//		Address ad = new Address();
//		AddressServicce addressServicce = new AddressServicceImpl();
//		addressServicce.input(ad);
//		st.setAddress(ad);
	}

	@Override
	public void info(Student st) {
		System.out.println("Student Infor");
		System.out.println("ID: " + st.getId());
		System.out.println("Name: " + st.getName());
		System.out.println("Age: " + st.getAge());
		
		if (st.getSchool() != null) {
			SchoolService sls = new SchoolServiceImpl();
			sls.info(st.getSchool());
		}

		if (st.getAddress() != null) {
			AddressService ads = new AddressSerivceImpl();
			ads.info(st.getAddress());
		}
		
		System.out.println("------------------------------");
	}

}
