package com.cice.modelo;

/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */

public class Contacto {
	private String dni;
	private String nombre;
	
	public Contacto(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	public Contacto() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
