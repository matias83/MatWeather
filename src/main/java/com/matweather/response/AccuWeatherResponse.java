package com.matweather.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.matweather.entity.Temperature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccuWeatherResponse {
	@JsonProperty("LocalObservationDateTime")
	private String localObservationDateTime;
	
	@JsonProperty("WeatherText")
	private Long epochTime;
	
	@JsonProperty("WeatherIcon")
	private Integer weatherIcon;
	
	@JsonProperty("HasPrecipitation")
	private Boolean hasPrecipitation;
	
	@JsonProperty("PrecipitationType")
	private String precipitationType;
	
	@JsonProperty("IsDayTime")
	private Boolean isDayTime;
	
	@JsonProperty("Temperature")
	private Temperature temperature;
	
	@JsonProperty("MobileLink")
	private String mobileLink;
	
	@JsonProperty("Link")
	private String link;
}
