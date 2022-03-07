package model;

public class Student extends Person {
	private String studentClass;
	
	private Laptop[] laptops;
	
	// class con bat buoc phai goi class cha, neu khong phai co contructor default
	public Student() {
		super(0, "test");
	}
	
	public Student(int age, String name) {
		super(age, name);
	}
	
	@Override
	public void input() {
		super.input();
	}
	
	public Laptop[] getLaptops() {
		return laptops;
	}

	public void setLaptops(Laptop[] laptops) {
		this.laptops = laptops;
	}

	@Override
	public void info() {
		super.info();
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
}
