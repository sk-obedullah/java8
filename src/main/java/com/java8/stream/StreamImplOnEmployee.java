package com.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamImplOnEmployee {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		employeeList.add(new Employee(288, "Anuj Patil", 31, "Others", "IT Development", 2012, 35000.0));
		employeeList.add(new Employee(288, "Anuj Patil", 35, "Others", "IT Development", 2013, 32000.0));

//		 How many male and female employees are there in the organization?

		long count = employeeList.stream().filter(e -> e.getGender().equalsIgnoreCase("Male")).count();
		System.out.println("Male Emp : " + count);
		long count1 = employeeList.stream().filter(e -> e.getGender().equalsIgnoreCase("Female")).count();
		System.out.println("Male Emp : " + count1);

		Map<String, Long> collect = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(collect);

//		Print the name of all departments in the organization?

		List<String> collect2 = employeeList.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		System.out.println("DepartMents-> " + collect2);
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

//		 What is the average age of male and female employees?

		Map<String, Double> collect3 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("avarage age by gender :: " + collect3);

//		Get the details of highest paid employee in the organization?

		Optional<Employee> collect4 = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println("Highest paid employee -> " + collect4.get());
		
		Employee employee4 = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("-----------------"+employee4);

//		 Get the names of all employees who have joined after 2015?

		List<String> collect5 = employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
				.collect(Collectors.toList());
		System.out.println("Emplyye joined After 2015 -> " + collect5);

//		Count the number of employees in each department?

		Map<String, Long> collect6 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Number Of Employee by Department -> " + collect6);

//		What is the average salary of each department?

		Map<String, Double> collect7 = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(collect7);

//		Get the details of youngest male employee in the product development department?

		Optional<Employee> collect8 = employeeList.stream()
				.filter(e -> e.getGender().equalsIgnoreCase("Male")
						&& e.getDepartment().equalsIgnoreCase("Product Development"))
				.collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
		System.out.println(collect8.get().getName());

//		Who has the most working experience in the organization?

		Employee employee = employeeList.stream()
				.collect(Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining))).get();
		System.out.println(employee);

		// Or

		Employee employee2 = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst()
				.get();
		System.out.println(employee2);

//		How many male and female employees are there in the sales and marketing team?

		Map<String, Long> collect9 = employeeList.stream().filter(e -> e.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(collect9);

//		 What is the average salary of male and female employees?

		Map<String, Double> collect10 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(collect10);

//		 List down the names of all employees in each department?

		Map<String, List<Employee>> collect11 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(collect11);

//		 What is the average salary and total salary of the whole organization

		DoubleSummaryStatistics collect12 = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getAge));
		System.out.println(collect12.getAverage());
		System.out.println(collect12.getSum());

		Double collect13 = employeeList.stream().collect(Collectors.summingDouble(Employee::getAge));
		System.out.println(collect13);

		Double collect14 = employeeList.stream().collect(Collectors.averagingDouble(Employee::getAge));
		System.out.println(collect14);

//		Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.

		Map<Boolean, List<Employee>> collect15 = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		System.out.println(collect15);

//		Who is the oldest employee in the organization? What is his age and which department he belongs to?

		Employee employee3 = employeeList.stream().max(Comparator.comparing(Employee::getAge)).get();

		System.out.println(employee3);

		// 142. java 8 program to find the employee name starts with A and salary is
		// greater than 500000?
		List<String> collect16 = employeeList.stream()
				.filter(emp -> emp.name.startsWith("A") && emp.getSalary() < 25000).map(emp -> emp.getName())
				.collect(Collectors.toList());

		System.out.println(collect16);

		// 141. Find the duplicate employeeName in given list

	 

		Map<String, List<Employee>> collect17 = employeeList.stream().collect(Collectors.groupingBy(Employee::getName));
		List<Employee> collect18 = collect17.values().stream().filter(empList -> empList.size() > 1)
				.flatMap(list -> list.stream()).collect(Collectors.toList());

		System.out.println(collect18);

	}
}
