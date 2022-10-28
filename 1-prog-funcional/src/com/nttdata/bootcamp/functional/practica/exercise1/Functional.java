package com.nttdata.bootcamp.functional.practica.exercise1;

import java.util.List;

public class Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);

		Long count = numbers.stream().filter(num -> num > 10).count();

		System.out.println(count);
	}
}
