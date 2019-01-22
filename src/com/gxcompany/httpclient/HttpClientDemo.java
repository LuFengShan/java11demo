package com.gxcompany.httpclient;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * HttpClient在标准库包java.net中
 * HttpClient可以同步或异步使用。同步请求会阻止当前线程，直到响应可用。
 * BodyHandlers定义响应体的预期类型（例如，字符串，字节数组或文件）
 */
public class HttpClientDemo {

	/**
	 * 同步执行，阻塞其它线程
	 */
	@Test
	public void testGetSynchronized() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.sqlstyle.guide/zh/"))
				.GET() // GET()方法可以省略，因为它是默认的请求方法。
				.build();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// System.out.println(response.body()); // 输出，网页的所有的内容
		System.out.println(response.version()); // http的版本
	}

	/**
	 * 异步执行请求。调用sendAsync不会阻塞当前线程，而是返回一个CompletableFuture构造异步操作管道。
	 */
	@Test
	public void testGetSendAsync() {
		var request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.baidu.com"))
				.build();
		var client = HttpClient.newHttpClient();
		CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		future.thenApply(HttpResponse::body).thenAccept(System.out::println);
	}

	/**
	 * BodyPublishers来定义要作为请求主体发送的数据类型，例如字符串，字节数组，文件或输入流
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void testPOST() throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder()
				.uri(URI.create("https://postman-echo.com/post"))
				.header("Content-Type", "text/plain")
				.POST(HttpRequest.BodyPublishers.ofString("foo1=bar1&foo2=bar2"))
				.build();
		var client = HttpClient.newHttpClient();
		var response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());      // 200
	}

	/**
	 * 通过BASIC-AUTH以下方式执
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void testBASIC_AUTH() throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder()
				.uri(URI.create("https://postman-echo.com/basic-auth"))
				.build();

		var client = HttpClient.newBuilder()
				.authenticator(new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("postman", "password".toCharArray());
					}
				})
				.build();
		var response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());      // 200
	}

}
