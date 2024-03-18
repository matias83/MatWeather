package com.matweather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temperature {
	@JsonProperty("Metric")
	private Metric metric;
	
	@JsonProperty("Imperial")
	private Imperial imperial;
}
