package com.ericsson.anuncio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	String nombre;
	String asunto;
	String comentarios;
	
	public Anuncio() {}

	public Anuncio(
			String nombre,
			String asunto,
			String comentarios)
	{
		this.nombre = nombre;
		this.asunto = asunto;
		this.comentarios = comentarios;
	}
	
	public String getNombre() {
		return this.nombre;
		}
	
	public String getAsunto() {
		return this.asunto;
		}

	public String getComentarios() {
		return this.comentarios;
		}

}
