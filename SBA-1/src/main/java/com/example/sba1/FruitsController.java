package com.example.sba1;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FruitsController {
	
	private static final String template = "Fruit name is, %s!";
	// AtomicLong is a datatype that will handle huge data
	
	private final AtomicLong atomicLong = new AtomicLong();
	
	@GetMapping("/fruits")
	public Fruits fruits(@RequestParam(value = "fruitname", defaultValue = "Apple") String fruitname)
	{ 		
		return new Fruits(atomicLong.incrementAndGet(), String.format(template, fruitname)); 	
	}
	 

}
