package com.gxcompany.collect;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class CollectDemo {
	@Test
	public void testList() {
		// List.of从给定的参数创建了一个新的不可变列表
		var list = List.of("我", "wo", "I");
		// List.copyOf(list),复制一个不可变的列表
		var copyOf = List.copyOf(list);
		copyOf.forEach(System.out::println);
	}

	@Test
	public void testMap() {
		var map = Map.of("A", 11, "B", 22, "C", 33);
		map.forEach((key, val) -> System.out.println(key + " : " +val));
	}
}
