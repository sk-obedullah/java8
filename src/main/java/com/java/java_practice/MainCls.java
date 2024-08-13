package com.java.java_practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainCls {

	public static void main(String[] args) {
		List<Employees> employeeList = new ArrayList<>();

		employeeList.add(new Employees(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employees(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employees(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employees(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employees(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employees(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employees(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employees(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employees(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employees(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employees(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employees(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employees(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employees(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employees(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employees(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employees(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

//		 How many male and female employees are there in the organization?
		Map<String, Long> collect = employeeList.stream()
				.collect(Collectors.groupingBy(Employees::getGender, Collectors.counting()));
		System.out.println(collect);

		Map<Boolean, List<Employees>> collect2 = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getGender().equals("Male")));
		System.out.println(collect2);

		employeeList.stream().map(e -> e.getDepartment()).distinct().forEach(dep -> System.out.println(dep));

		Set<String> collect3 = employeeList.stream().map(e -> e.getDepartment()).collect(Collectors.toSet());
		System.out.println(collect3);

		Map<String, Double> collect4 = employeeList.stream()
				.collect(Collectors.groupingBy(Employees::getGender, Collectors.averagingDouble(Employees::getAge)));
		System.out.println(collect4);

		Employees employees = employeeList.stream().sorted(Comparator.comparingDouble(Employees::getSalary).reversed())
				.skip(1).findFirst().get();
		System.out.println(employees);

//		 Get the names of all employees who have joined after 2015?

		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employees::getName)
				.forEach(System.out::println);

//		 Count the number of employees in each department?

		Map<String, Long> collect5 = employeeList.stream()
				.collect(Collectors.groupingBy(Employees::getDepartment, Collectors.counting()));
		System.out.println(collect5);

//		 What is the average salary of each department?

		Map<String, Double> collect6 = employeeList.stream().collect(
				Collectors.groupingBy(Employees::getDepartment, Collectors.averagingDouble(Employees::getSalary)));
		System.out.println(collect6);

//		 Get the details of youngest male employee in the product development department?
		Employees employees2 = employeeList.stream()
				.filter(emp -> emp.getGender().equalsIgnoreCase("Male")
						&& emp.getDepartment().equalsIgnoreCase("Product Development"))
				.sorted(Comparator.comparing(Employees::getAge)).findFirst().get();
		System.out.println(employees2);

		// OR

		Employees employees3 = employeeList.stream()
				.filter(emp -> emp.getGender().equalsIgnoreCase("Male")
						&& emp.getDepartment().equalsIgnoreCase("Product Development"))
				.min(Comparator.comparing(Employees::getAge)).get();
		System.out.println(employees3);

//		 Who has the most working experience in the organization?
		Employees employees4 = employeeList.stream().min(Comparator.comparing(Employees::getYearOfJoining)).get();
		System.out.println(employees4);

//		 How many male and female employees are there in the sales and marketing team?
		Map<String, Long> collect7 = employeeList.stream()
				.filter(emp -> emp.getDepartment().equalsIgnoreCase("sales and marketing"))
				.collect(Collectors.groupingBy(Employees::getGender, Collectors.counting()));
		System.out.println(collect7);

//		What is the average salary of male and female employees?
		Map<String, Double> collect8 = employeeList.stream()
				.collect(Collectors.groupingBy(Employees::getGender, Collectors.averagingDouble(Employees::getSalary)));
		System.out.println(collect8);

//		List down the names of all employees in each department?
		Map<String, List<String>> collect9 = employeeList.stream().collect(Collectors
				.groupingBy(Employees::getDepartment, Collectors.mapping(Employees::getName, Collectors.toList())));
		System.out.println(collect9);

//		get map of department name and list of emp name whose salary>25k 
		Map<String, List<String>> collect10 = employeeList.stream().collect(
				Collectors.groupingBy(Employees::getDepartment, Collectors.filtering(emp -> emp.getSalary() > 25000,
						Collectors.mapping(e -> e.getName(), Collectors.toList()))));
		System.out.println(collect10);

//		OR
		Map<String,List<String>> collect11 = employeeList.stream().filter(emp->emp.getSalary()>25000)
				.collect(Collectors.groupingBy(Employees::getDepartment,Collectors.mapping(Employees::getName, Collectors.toList())));
		System.out.println(collect11);
		
//		What is the average salary and total salary of the whole organization?
		DoubleSummaryStatistics collect12 = employeeList.stream().collect(Collectors.summarizingDouble(Employees::getSalary));
		System.out.println(collect12);
		
//		Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		Map<Boolean,List<Employees>> collect13 = employeeList.stream().collect(Collectors.partitioningBy(emp->emp.getAge()>25));
		System.out.println(collect13);
		
//		Who is the oldest employee in the organization? What is his age and which department he belongs to?
		Employees employees5 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employees::getAge))).get();
		System.out.println(employees5);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
