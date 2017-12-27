package com.example.demo;

import java.util.Hashtable;
/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class TablaContactos {
	//falta metodo validar dni
	private Hashtable<String,String> listaContactos;
/**
 * Constructor de la clase TablaContactos
 */
	public TablaContactos() {
		super();
		this.listaContactos = new Hashtable<String, String>();
	}
	
	/**
	 * 
	 * @param dni dni del usuario a añadir
	 * @param nombre nombre del usuario a añadir
	 */
	public void aniadirContacto(String dni, String nombre) {
		if(!this.listaContactos.contains(dni)){
			this.listaContactos.put(dni, nombre);	
			
		}
		
	}
	
	/**
	 * 
	 * @param dni dni del usuario a eliminar
	 */
	
	public void eliminarContacto(String dni) {
		if(this.listaContactos.containsKey(dni)) {
			this.listaContactos.remove(dni);
		}
	}
	
	/**
	 * método que imprime los contactos de la listaContactos 
	 */
	
	public void imprimirContactos() {
		this.listaContactos.forEach((k,v)->System.out.println("El contacto con DNI --> " + k + " tiene el nombre --> " + v));
	}
	
	

}
