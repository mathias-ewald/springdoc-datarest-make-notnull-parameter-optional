package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private MustardGlassRepo repo;
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    repo.save(MustardGlass.builder().name("Salty Mustard").owner("OwnerA").build());
	    repo.save(MustardGlass.builder().name("Spicy Mustard").owner("OwnerB").build());
	    repo.save(MustardGlass.builder().name("Sweet Mustard").owner("OwnerC").build());
	}
	
}
