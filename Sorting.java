package com.intrvw;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamQuestions3_Sorting {
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
		List<Integer> numsRes;
		
		List<String> names;
		List<String> namesRes;
		
		Person p1 = new Person("Suraj", 24);
		Person p2 = new Person("Deepak", 27);
		Person p3 = new Person("Akshay", 28);
		Person p4 = new Person("Samrat", 24);
		
		List<Person> persons = List.of(p1, p2, p3, p4);
		List<Person> personsRes;
		
		//1. Sort a list of integers in descending order
		nums = List.of(5, 2, 9, 1, 3);
		numsRes = nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(numsRes);
		
		//2. Sort a list of strings alphabetically (natural order)
		names = List.of("Charlie", "Alice", "Bob");
		namesRes = names.stream().sorted().collect(Collectors.toList());
		System.out.println(namesRes);
		
		//3. Sort a list of strings in reverse alphabetical order
		names = List.of("Charlie", "Alice", "Bob");
		namesRes = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(namesRes);
		
		//4. Sort a list of strings by length (shortest to longest)
		names = List.of("Java", "Streams", "API");
		namesRes = names.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
		System.out.println(namesRes);
		
		//5. Sort a list of strings by length (longest to shortest)
		names = List.of("Java", "Streams", "API");
		namesRes = names.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
		System.out.println(namesRes);
		
		//6. Sort a list of custom objects by a field (e.g., age)
		personsRes = persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
		System.out.println(personsRes);
		
		//7. Sort a list of custom objects by multiple fields (e.g., by age, then by name)
		personsRes = persons.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).collect(Collectors.toList());
		System.out.println(personsRes);
		
		//8. Find the person with the maximum age
		Optional<Person> maxAge = persons.stream().max(Comparator.comparing(Person::getAge));
		maxAge.ifPresent(System.out::println);
		
		//9. Get the top 3 highest scores
		nums = List.of(99, 85, 70, 92, 88);
		numsRes = nums.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		System.out.println(numsRes);
		
		//10. Get the bottom 2 lowest scores from a list
		nums = List.of(99, 85, 70, 92, 88);
		numsRes = nums.stream().sorted().limit(2).collect(Collectors.toList());
		System.out.println(numsRes);
	}
}
