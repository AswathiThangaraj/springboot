package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//The controller will ensure that the class will control how the object will be used
//It is done using 2 parts
//1. Get mapping
//2. Request param

@RestController
public class GreetingController {
	//s is a placeholder of run time value
	//for eg: if user inputs: "abcd"
	//result will be "Hello, abcd"
	private static final String template = "Hello, %s!";
	// AtomicLong is a datatype that will handle huge data
	
	private final AtomicLong atomicLong = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
	{ 		
		return new Greeting(atomicLong.incrementAndGet(), String.format(template, name)); 	
	}
	 

}
