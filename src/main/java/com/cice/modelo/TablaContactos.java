package com.cice.modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class TablaContactos {
	
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
	 * @param dni del usuario a añadir
	 * @param nombre del usuario a añadir
	 */
	public boolean aniadirContacto(String dni, String nombre) {
		if(!this.listaContactos.containsKey(dni)){
			this.listaContactos.put(dni, nombre);
			return true;
			
		}
		else
			return false;
	}
	
	/**
	 * 
	 * @param dni del usuario a eliminar
	 */
	
	public boolean eliminarContacto(String dni) {
		if(this.listaContactos.containsKey(dni)) {
			this.listaContactos.remove(dni);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * método que imprime los contactos de la listaContactos 
	 */
	
	public void imprimirContactos() {
		for(String clave :this.listaContactos.keySet()) {
			System.out.println("Contacto con DNI --> " + clave + " tiene el nombre --> " + this.listaContactos.get(clave));	
		}		
		
	}
	
	/**
	 * 
	 * @param dni a validar
	 * @return true or false si es válido
	 */
	
	public static boolean validar(String dni) {
		
		String letraMayuscula="";
		
		if(dni.length()!=9||!Character.isLetter(dni.charAt(8)))
			return false;
		
		letraMayuscula = dni.substring(8).toUpperCase();
		
		if(TablaContactos.validarNumeros(dni) && TablaContactos.calcularLetraDNI(dni).equals(letraMayuscula))
			
			return true;
		else		
			return false;
	}
		/**
		 * 
		 * @return true or false si todas las posiciones de 0 a 8 son numeros
		 */
	public static boolean validarNumeros(String dni) {
			
			List <String> listaNumeros = new ArrayList<> ();
			String miDNI = "";
						
			for (int i = 0; i < 10; i++)
				listaNumeros.add(String.valueOf(i));
			
			for(int  i = 0; i<dni.length()-1; i++) {
				for (String string : listaNumeros) {
					if(dni.substring(i,i+1).equals(string))
					miDNI+=string;				
				}
			}		
			
			
			if(miDNI.length()!=8)
				return false;
			else
				return true;
		}
	
		
/**
 * 		
 * @return letra del DNI
 */
		public static String calcularLetraDNI(String dni) {
			int miDNI = Integer.parseInt(dni.substring(0,8));
			int resto = 0;
			String letra = "";
			String [] asignacionLetra = {"T", "R", "W", "A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
			
			resto = miDNI%23;
			letra = asignacionLetra[resto];
			return letra;
		
		}
	

}
