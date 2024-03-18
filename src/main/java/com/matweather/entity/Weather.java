package com.matweather.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
	private String localObservationDateTime;
	private Long epochTime;
	private Integer weatherIcon;
	private Boolean hasPrecipitation;
	private String precipitationType;
	private Boolean isDayTime;
	private Temperature temperature;
	private String mobileLink;
	private String link;
}