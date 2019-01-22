package com.gxcompany.string;

import org.junit.jupiter.api.Test;

/**
 * String获取一些辅助方法来修剪或检查空格以及流式传输字符串的行
 */
public class StringDemo {
	@Test
	public void test() {
		// 检查空格
		System.out.println(" ".isBlank());               // true

		// 去除字符串两边的空格
		System.out.println(" 郑 州 ".strip());          // "郑 州"

		// 去除字符串右边的空格
		System.out.println(" 郑 州 ".stripTrailing());  // " 郑 州"

		// 去除字符串左边的空格
		System.out.println(" 郑 州 ".stripLeading());   // "郑 州 "

		// 返回一个字符串，其值是此字符串重复计数次数的串联。如果此字符串为空或count为零，则返回空字符串。
		System.out.println("上海".repeat(3));             // "上海上海上海"

		/**
		 * 返回从此字符串中提取的行的流，由行终止符分隔。
		 * 行终止符是以下之一：换行符“\ n”（U + 000A），回车符“\ n”（U + 000D）或回车符后面紧跟换行符“\r\n\n“（U + 000D U + 000A）。
		 * 一行是零个或多个字符的序列，后跟行终止符，或者是一个或多个字符的序列，后跟字符串的结尾。 一行不包括行终止符。
		 * 此方法返回的流包含此字符串中出现的行的行。
		 *
		 * 返回：
		 * 从该字符串中提取的行流
		 */
		System.out.println("我\n爱\n我".lines()
				.count());    // 3
	}
}
