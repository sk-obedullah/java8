package com.java8.stream;

public class ChotaEmp {

	private String name;
	private int Salary;
	private String departrment;

	public ChotaEmp() {
		super();
	}

	public ChotaEmp(String name, int salary, String departrment) {
		super();
		this.name = name;
		Salary = salary;
		this.departrment = departrment;
	}

	@Override
	public String toString() {
		return "ChotaEmp [name=" + name + ", Salary=" + Salary + ", departrment=" + departrment + "]";
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

	public String getDepartrment() {
		return departrment;
	}

	public void setDepartrment(String departrment) {
		this.departrment = departrment;
	}

}
