package com.gxcompany.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 三种新方法。
 * 1. Stream.ofNullable从单个元素构造流
 * 2. dropWhile和takeWhile都接受谓词来确定从流中放弃哪些元素：
 */
public class StreamDemo {

	@Test
	public void testStream() {
		// 从单个元素构造流
		var count = Stream.ofNullable("252")
				.count();
		System.out.println("count : " + count);

		var dropWhile = Stream.of(1, 2, 3, 2, 1)
				.dropWhile(n -> n < 3) // 放弃流中“第一个3”之前的元素，不包括3
				.map(String::valueOf)
				.collect(Collectors.joining("、","[","]")); // [3, 2, 1]
		System.out.println("dropWhile : " + dropWhile);

		var takeWhile = Stream.of(1, 2, 3, 2, 1)
				.takeWhile(n -> n < 3) // 放弃流中“第一个3”之后的所有元素，包括3
				.map(String::valueOf)
				.collect(Collectors.joining("、","[","]"));// [1, 2]
		System.out.println("takeWhile : " + takeWhile);

	}
}
