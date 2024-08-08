package com.java.java_practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparator {

	public static void main(String[] args) {
		Employee e1=new Employee(2, "sk");
		Employee e2=new Employee(1, "tbedullah");
		List<Employee> of = Arrays.asList(e1,e2);
		
		Comparator<Employee> nameComparator=(emp1,emp2)->{
			return emp1.getName().compareToIgnoreCase(emp2.getName());
		};
		
		Comparator<Employee> nameComp=Comparator.comparing(Employee::getName);
		
//		Collections.sort(of);
		Collections.sort(of, nameComp);
		System.out.println(of.toString());
	}
}

class Employee implements Comparable<Employee>{
	int id;
	String name;
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Employee o) {
		return Integer.compare(this.id, o.id);
	}
	
}