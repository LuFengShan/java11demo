package com.gxcompany.string;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Predicate;

public class VarDemo {
	public static void main(String[] args) {
		/**
		 * Java 10引入了一个新的语言关键字var，它可以在声明局部变量时替换类型信息（本地意味着方法体内的变量声明）
		 */
		// java 10 之前
		String java9 = "hello java9";

		// java 10及以后可以使用var，编译器从变量的赋值中推断出正确的类型。在这种情况下text是类型String
		var java10 = "hello java10";

		// 声明的变量var仍然是静态类型。您无法将不兼容的类型重新分配给此类变量。
		var java11 = "hello java11";
		// java11 = 50; //不兼容的类型,因为上面已经给过值了，是字符串类型

		String join = String.join("、", java9, java10, java11);
		System.out.println(join);

		// 您还可以final结合使用var以禁止将变量重新分配给另一个值：
		final var text = "LOL";
		// text = "CS";   // 无法为最终变量“text”赋值

		/**
		 * var这个变量，当编译器无法推断出这个变量的时候，也不允许这样做,如下：
		 * var a;
		 * var nothing = null;
		 * var lambda = () -> System.out.println("Pity!");
		 * var method = this::someMethod;
		 */

		/**
		 * 局部变量类型推断确实涉及泛型。在下一个示例中current有一个相当冗长的类型Map<String, List<Integer>>，
		 * 可以将其简化为单个var关键字，从而避免键入大量样板：
		 */
		var list = new ArrayList<Map<String, Integer>>();
		for (var param : list) {
			System.out.println(param);
		}
		list.forEach(System.out::println);

		// 从Java 11开始，lambda参数也允许使用var关键字，这使您可以为这些参数添加注释
		Predicate<String> predicate = (var a) -> true; // 生产者
	}
}
