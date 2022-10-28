package com.nttdata.bootcamp.functional.practica.exercise2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

enum Tax {
	SUPERREDUCED(4), REDUCED(10), NORMAL(21);
	
	public int percent;
	
	private Tax(int percent) {
		this.percent = percent;
	}

	public int getPercent() {
		return percent;
	}
}

class Product {
	
	public String name;
	public BigDecimal price;
	public Tax tax;

	Product(String name, BigDecimal price, Tax tax) {
		this.name = name;
		this.price = price;
		this.tax = tax;
	}
}

public class Exercise2 {
	
	public static void main(String[] args) {
		List<Product> shopping = List.of(
				new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
				new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
				new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
				new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
				new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
				new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));
		
		BigDecimal amount = shopping.stream()
				.map(x -> x.price.add(x.price.multiply(new BigDecimal(x.tax.percent)).divide(new BigDecimal(100))))
				.reduce(BigDecimal.ZERO, (x, y) -> x.add(y)).setScale(2, RoundingMode.CEILING);
		
		System.out.println("Total amount with taxes: " + amount);
		
		String productsStartsWithC = shopping.stream()
			.filter(x -> x.name.startsWith("C"))
			.sorted((x,y) -> x.name.compareToIgnoreCase(y.name))
			.map(x -> x.name)
			.collect(Collectors.joining(", ", "Products starts with C are ", "."));
		
		System.out.println(productsStartsWithC);
	}
}
