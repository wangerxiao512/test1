package com.yg.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo1 {

	public static void main(String[] args) {
		Optional<Object> op2 = Optional.ofNullable(null);
		System.out.println(op2);
	}

	public static void test2() {
		testConsumer("abccc", (s) -> System.out.println(s.subSequence(1, 2)));
		testSupplier(() -> "hello");
		testFunction(123, (x) -> x + 200);
		BiFunction<Integer, Integer, Integer> bf = (x, y) -> x + y;
		System.out.println(bf.apply(1, 2));
		Supplier<Person> p = Person::new;
		System.out.println(p.get());

		BiFunction<String, String, Person> bi = Person::new;
		System.out.println(bi.apply("0001", "张三"));
	}

	public static void testFunction(Integer i, Function<Integer, Integer> fun) {
		System.out.println(fun.apply(i));
	}

	public static void testSupplier(Supplier<String> sup) {
		sup.get();
	}

	public static void testConsumer(String s, Consumer<String> con) {
		con.accept(s);
	}

	public static void test1() {
		List<String> s = Arrays.asList("ab", "ac", "c");
		s.forEach(System.out::println);
		filter(s, (e) -> e.startsWith("a"));
	}

	public static void filter(List<String> list, Predicate<String> ll) {
		for (String s : list) {
			if (ll.test(s)) {
				System.out.println(s);
			}
		}
	}
}
