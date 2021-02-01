package com.example.demo;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@RepositoryEventHandler(MustardGlass.class)
@Component
public class OwnerInjector {

	@HandleBeforeCreate
	public void injectOwner(MustardGlass entity) {
		if (entity.getOwner() != null && entity.getOwner().trim().length() > 0)
			return;
		// Usually, I resolve the owner from the JWT token but for the sake of simplicity
		// I'll just generate an owner now.
		List<String> owners = List.of("OwnerA", "OwnerB", "OwnerC", "OwnerD");
		int randomNum = ThreadLocalRandom.current().nextInt(0, owners.size() - 1);
		entity.setOwner(owners.get(randomNum));
	}

}
