package service;

import java.util.Scanner;

import model.Address;

public class AddressSerivceImpl implements AddressService {

	@Override
	public void input(Address ad) {
		System.out.println("Address Input");
		System.out.println("ID: ");
		ad.setId(new Scanner(System.in).nextInt());
		System.out.println("Street: ");
		ad.setStreet(new Scanner(System.in).nextLine());
		System.out.println("City: ");
		ad.setCity(new Scanner(System.in).nextLine());
	}

	@Override
	public void info(Address ad) {
		System.out.println("Address Infor");
		System.out.println("ID: " + ad.getId());
		System.out.println("Street: " + ad.getStreet());
		System.out.println("City: " + ad.getCity());
		System.out.println("------------------------------");
	}
}
