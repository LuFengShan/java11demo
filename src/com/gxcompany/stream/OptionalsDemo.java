package com.gxcompany.stream;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Optionals还会收到一些非常方便的新方法，例如，您现在可以简单地将选项转换为流，或者为空选项提供另一个可选的后备：
 */
public class OptionalsDemo {
	@Test
	public void test() {
		Optional.of("foo").orElseThrow();     // foo
		Optional.of("foo").stream().count();  // 1
		Optional.ofNullable(null)
				.or(() -> Optional.of("fallback"))
				.get();                           // fallback
	}
}
