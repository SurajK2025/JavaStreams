package com.intrvw;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamQuestions5_MinMax {
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
		
		//1. Get the maximum value from a list of integers.
		nums = List.of(10, 25, 8, 31, 22);
		Optional<Integer> max = nums.stream().max(Integer::compareTo);
		max.ifPresent(System.out::println);
		
		//2. Get the minimum value from a list of integers.
		nums = List.of(10, 25, 8, 31, 22);
		Optional<Integer> min = nums.stream().min(Integer::compareTo);
		min.ifPresent(System.out::println);
		
		//3. Find the string with the longest length.
		names = List.of("apple", "banana", "watermelon", "grape", "kiwi");
		Optional<String> longestString = names.stream().max(Comparator.comparingInt(String::length));
		longestString.ifPresent(System.out::println);
		
		//4. Find the oldest person
		Optional<Person> oldestPerson = persons.stream().max(Comparator.comparingInt(Person::getAge));
		oldestPerson.ifPresent(System.out::println);
	}
}
