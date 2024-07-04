package com.java8.stream;

public class ChotaEmp {

	private String name;
	private int Salary;
	@Override
	public String toString() {
		return "ChotaEmp [name=" + name + ", Salary=" + Salary + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public ChotaEmp(String name, int salary) {
		super();
		this.name = name;
		Salary = salary;
	}
	public ChotaEmp() {
		super();
	}
	
	
}
