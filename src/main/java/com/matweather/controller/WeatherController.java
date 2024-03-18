package com.matweather.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.matweather.business.WeatherBusiness;
import com.matweather.entity.Weather;
import com.matweather.response.AccuWeatherResponse;
import com.matweather.response.BaseResponse;



/**
 * Toda clase Controller se encarga de:
 * 
 * 		1) Escuchar los mensajes provenientes del Cliente.
 * 
 * 		2) Enviar los mensajes provenientes el Cliente al Business y luego escuchar su respuesta.
 * 			NOTA: No hay que validar los mensajes, los mismos serán validados en el Business
 * 
 * 		3) Armar la respuesta para enviarle al Cliente que lo invocó.  		
 * 
 *  	4) Responderle al Cliente que lo invocó. 
 * 
 * */
@RestController
@RequestMapping("/v0/weathers")
public class WeatherController {
/*	
	@Autowired
	private RestTemplate clientRest;
*/	
	@Autowired
	private WeatherBusiness weatherBusiness;
	
	@GetMapping(value="")
	public ResponseEntity<BaseResponse> get() throws Exception {
		
		BaseResponse<List<Weather>> response = new BaseResponse<List<Weather>>();
	
		try {
			//http://dataservice.accuweather.com/currentconditions/v1/7894
			//getWeather();
			//getAccuWeatherResponse();
			
			System.err.println("VAMOOOO");
			
			List<Weather> Weathers = weatherBusiness.listar();
			
			response.setCode(HttpStatus.OK.value());
			
			if(Weathers != null && !Weathers.isEmpty()) {
				response.setPayload(Weathers);
				
				response.setMessage("Weather_ENCONTRADA");
				response.setDescription("Se encontró " + Weathers.size() + " Weather/s");
			}		
			else {				
				response.setMessage("NO_HAY_WeatherS");
				response.setDescription("No se encontraron Weathers");
			}
			
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getWeather() {
        // URL del endpoint
        String endpointUrl = "https://dataservice.accuweather.com/currentconditions/v1/7894?apikey=wkMICzFuDArfT7aAI3CfEJlSN3IAB2m2&language=en-us&details=false";

        // Crear RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Realizar la solicitud y obtener la respuesta
        String response = restTemplate.getForObject(endpointUrl, String.class);

        // Retornar la respuesta
        return response;
    }
	
	private List<AccuWeatherResponse> getAccuWeatherResponse() {
		
		// URL del endpoint
        String endpointUrl = "https://dataservice.accuweather.com/currentconditions/v1/7894?apikey=wkMICzFuDArfT7aAI3CfEJlSN3IAB2m2&language=en-us&details=false";

        // Crear RestTemplate
        RestTemplate restTemplate = new RestTemplate();

     // Realizar la solicitud y obtener la respuesta
        String response = restTemplate.getForObject(endpointUrl, String.class);
        //List<AccuWeatherResponse> response = Arrays.asList(restTemplate.getForObject(endpointUrl, AccuWeatherResponse[].class));

        // Retornar la respuesta
        return null;
		/*
		HashMap<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", "7894");
		
			
		String queryParams = getQueryParams();
		
		//AccuWeatherResponse weatherResponse = clientRest.getForObject("http://dataservice.accuweather.com/currentconditions/v1/7894", AccuWeatherResponse.class, pathVariables);
		//AccuWeatherResponse weatherResponse = clientRest.getForObject("http://dataservice.accuweather.com/currentconditions/v1/{id}?"+queryParams, AccuWeatherResponse.class, pathVariable);
		List<AccuWeatherResponse> weatherResponse = Arrays.asList(clientRest.getForObject("http://dataservice.accuweather.com/currentconditions/v1/7894?"+queryParams, AccuWeatherResponse.class)); 
				
				
		return weatherResponse;
		*/
	}

	private String getQueryParams() {
		/*HashMap<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("apikey", "wkMICzFuDArfT7aAI3CfEJlSN3IAB2m2");
		queryParams.put("language", "en-us");
		queryParams.put("details", "false");
		*/
		return "apikey=wkMICzFuDArfT7aAI3CfEJlSN3IAB2m2" + "&" + "language=en-us" + "&" + "details=false";
	}
}
