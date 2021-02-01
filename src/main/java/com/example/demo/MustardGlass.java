package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MustardGlass {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	// The property is not required on the REST level since
	// we inject a value if none exists but these annotations
	// don't work
    @Schema(required = false)
    @Parameter(required = false)
    // On the persistence layer the property is required
	@NotNull
	private String owner;

}
