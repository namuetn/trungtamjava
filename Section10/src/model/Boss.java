package model;

public class Boss extends Person{
	private int price;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public void salary() {
		int total = getPrice() + (getPrice() % 20);
		System.out.println("Boss salary:" + total + "tr");		
	}
}
