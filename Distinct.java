package com.intrvw;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamQuestions4_Distinct {

	private static class Person {
		String name;
		Integer age;
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
		public boolean equals(Object obj) {
			if(this == obj) return true;
			if(!(obj instanceof Person)) return false;
			Person person = (Person) obj;
			return this.name.equals(person.getName()) && this.age.equals(person.getAge());
		}
		@Override
		public int hashCode() {
			return Objects.hash(this.name, this.age);
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
	}

	public static void main(String[] args) {
		List<Integer> nums;
		List<Integer> numsRes;

		List<String> names;
		List<String> namesRes;

		Person p1 = new Person("Suraj", 24);
		Person p2 = new Person("Deepak", 27);
		Person p3 = new Person("Akshay", 28);
		Person p4 = new Person("Suraj", 24);

		List<Person> persons = List.of(p1, p2, p3, p4);
		List<Person> personsRes;

		//1. Get all distinct names
		names = Arrays.asList("John", "Mike", "John", "Anna");
		namesRes = names.stream().distinct().collect(Collectors.toList());
		System.out.println(namesRes);

		//2. Get all distinct names, regardless of case sensitivity
		names = Arrays.asList("John", "mike", "JOHN", "Mike", "Anna");
		namesRes = names.stream().map(String::toLowerCase).distinct().collect(Collectors.toList());
		System.out.println(namesRes);

		//3. Count the number of distinct elements in a list
		nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
		Long distinctCount = nums.stream().distinct().count();
		System.out.println(distinctCount);

		//4. Remove duplicates based on both name and age.
		personsRes = persons.stream().distinct().collect(Collectors.toList());
		System.out.println(personsRes);
	}
}
