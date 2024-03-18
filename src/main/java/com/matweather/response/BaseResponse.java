package com.matweather.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {	// La T indica que el atributo payload puede ser cualquier clase.
	private Integer code;		// Código de respuesta HTTP.
	private T payload;			// payload es del tipo genérico.
	private String message;		// Mensaje corto que describe el resultado.
	private String description; // Mensaje que vé el usuario por pantalla.
}