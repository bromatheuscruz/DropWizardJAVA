package cruz.io.learning.dropwizard.api.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product implements Serializable{
	
	/**
	 * 
	 */	
	private static final long serialVersionUID = 905516216757955049L;

	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String description;
	
	public Product() {
		
	}

	public Product(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
