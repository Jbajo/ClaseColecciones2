package com.example.demo;

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
	 * @param dni dni del usuario a añadir
	 * @param nombre nombre del usuario a añadir
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
	 * @param dni dni del usuario a eliminar
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
		this.listaContactos.forEach((k,v)->System.out.println("Contacto con DNI --> " + k + " tiene el nombre --> " + v));
	}
	
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
			final String [] miDNI = new String [] {""};
						
			for (int i = 0; i < 10; i++)
				listaNumeros.add(String.valueOf(i));
			
			
			for(final int [] i = new int [] {0}; i[0]<dni.length()-1;i[0]++) {
				listaNumeros.forEach(k->{
					if(dni.substring(i[0], i[0]+1).equals(k))
						miDNI[0] +=k;				
				});		
				
			}		
			
			if(miDNI[0].length()!=8)
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
