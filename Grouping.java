package com.intrvw;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamQuestions8_Grouping {
	private static class Employee {
	    String name;
	    int age;
	    int deptId;
	    double salary;
		public Employee(String name, int age, int deptId, double salary) {
			super();
			this.name = name;
			this.age = age;
			this.deptId = deptId;
			this.salary = salary;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getDeptId() {
			return deptId;
		}
		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Employee [name=" + name + ", age=" + age + "]";
		}
	}
	
	public static void main(String[] args) {
		List<Integer> nums;
		List<Integer> numsResult;
		
		List<String> names;
		List<String> namesResult;
		
		Employee e1 = new Employee("Suraj", 24, 1, 50000L);
		Employee e2 = new Employee("Deepak", 27, 1, 10000L);
		Employee e3 = new Employee("Akshay", 28, 2, 20000L);
		Employee e4 = new Employee("Samrat", 24, 2, 40000L);
		
		List<Employee> employees = List.of(e1, e2, e3, e4);
		List<Employee> personsRes;
		
		//1. Group strings by their length
		names = Arrays.asList("cat", "dog", "elephant", "ant");
		Map<Integer, List<String>> mapRes = names.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(mapRes);
		
		//2. Group numbers by even and odd
		nums = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<String, List<Integer>> mapRes2 = nums.stream().collect(Collectors.groupingBy(x -> (x%2==0) ? "Even" : "Odd"));
		System.out.println(mapRes2);
		
		//3. Group employees by department
		Map<Integer, List<Employee>> mapRes3 = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId));
		System.out.println(mapRes3);
		
		//4. Group employees by department and collect names
		Map<Integer, List<String>> mapRes4 = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(mapRes4);
		
		//5. Group strings by first character
		names = Arrays.asList("apple", "apricot", "banana", "blueberry");
		Map<Character, List<String>> mapRes5 = names.stream().collect(Collectors.groupingBy(x -> x.charAt(0)));
		System.out.println(mapRes5);
		
		//6. Group employees by department and count them
		Map<Integer, Long> mapRes6 = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
		System.out.println(mapRes6);
		
		//7. Group employees by department and compute aggregate salary
		Map<Integer, Double> mapRes7 = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(mapRes7);
		
		//8. Group employees by department and compute total salary
		Map<Integer, Double> mapRes8 = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.summingDouble(Employee::getSalary)));
		System.out.println(mapRes8);
	}
}
