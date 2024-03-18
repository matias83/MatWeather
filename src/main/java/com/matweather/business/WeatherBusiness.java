package com.matweather.business;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matweather.entity.Weather;
/*
import com.persona.dao.PersonaDAO;
import com.persona.entity.Persona;
import com.persona.exception.DuplicateKeyException;
import com.persona.exception.InvalidFieldException;
*/
/**
 * Toda clase Business se encarga de:
 * 
 * 		1) Escuchar los mensajes provenientes del Controller
 * 
 * 		2) Hacer las validaciones:
 * 			a) de los parámetros pasados desde el Controller
 * 			b) de negocio
 * 
 * 		3) Hacer la lógica de negocio
 * 
 * 		4) Comunicarse con el DAO  		
 * 
 *  	5) Responderle al Controller que lo invocó 
 * 
 * */

@Service
public class WeatherBusiness {
	/*
	@Autowired
	private WeatherDAO weatherDAO;
	*/
	public List<Weather> listar() {		
		return null; //weatherDAO.listar();
	}

}
