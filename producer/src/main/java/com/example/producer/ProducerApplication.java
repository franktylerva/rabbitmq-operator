package com.example.producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
}

@RestController
@RequiredArgsConstructor
class ProducerController {

	final StreamBridge streamBridge;

	@GetMapping("/")
	public String postMessage() {
		Person p = new Person("John Doe", 28);
		streamBridge.send("consumer1-in-0", p);
		return "message sent";
	}
}

@Data
@AllArgsConstructor
class Person {
	String name;
	int age;
}