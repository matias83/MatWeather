package com.matweather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Imperial {
	@JsonProperty("Value")
	private Float value;
	
	@JsonProperty("Unit")
	private String unit;
	
	@JsonProperty("UnitType")
	private Integer unitType;
}
