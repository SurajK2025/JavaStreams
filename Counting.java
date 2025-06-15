package com.intrvw;

import java.util.List;
import java.util.stream.Collectors;

public class StreamQuestions6_Counting {
	private static class Person {
	    String name;
	    int age;
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
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
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
	}
	
	public static void main(String[] args) {
		List<Integer> nums;
		List<Integer> numsResult;
		
		List<String> names;
		List<String> namesResult;
		
		Person p1 = new Person("Suraj", 24);
		Person p2 = new Person("Deepak", 27);
		Person p3 = new Person("Akshay", 28);
		Person p4 = new Person("Samrat", 24);
		
		List<Person> persons = List.of(p1, p2, p3, p4);
		List<Person> personsRes;
		
		Long count;
		
		//1. Count number of people
		count = persons.stream().count();
		System.out.println(count);
		
		//2. Count nums > 10
		nums = List.of(55,2,18,21,4);
		count = nums.stream().filter(x -> x>10).collect(Collectors.counting());
		System.out.println(count);
	}
}
