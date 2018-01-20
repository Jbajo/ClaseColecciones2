package com.cice.modelo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class TablaContactos {
	
	private Hashtable<String, Contacto> tablaContactos;	
/**
 * Constructor de la clase TablaContactos
 */
	public TablaContactos() {		
		this.tablaContactos = new Hashtable<String, Contacto>();
	}
	
	/**
	 * Método aniadirContacto añade un Contacto al Hashtable
	 * @param dni del usuario a añadir
	 * @param nombre del usuario a añadir
	 */
	public boolean aniadirContacto(String dni, Contacto contacto) {
		if(!this.tablaContactos.containsKey(dni)){
			this.tablaContactos.put(dni, contacto);
			return true;			
		}
		else
			return false;
	}
	
	/**
	 * Méotdo eliminarContacto elimina un contacto si encuentra el DNI en la clave
	 * @param dni del usuario a eliminar
	 * @return 0 si elimina el elemento, 1 si el DNI es erróneo y 2 si la tabla está vacía
	 */
	
	public int eliminarContacto(String dni) {
	
		if(this.tablaContactos.isEmpty())
			return 2;
			
		if(this.tablaContactos.containsKey(dni)) {
			this.tablaContactos.remove(dni);
			return 0;
		}
		else {
			return 1;
		}
	}
	
	/**
	 * Método imprimirContactos imprime los contactos de la tablaContactos 
	 */
	
	public void imprimirContactos() {
		Set <String> values = tablaContactos.keySet();
		
		for (Iterator<String> iterator = values.iterator(); iterator.hasNext();) {
			for(Enumeration<Contacto> aux = tablaContactos.elements();aux.hasMoreElements();) {
				System.out.println("Contacto con DNI --> " + iterator.next() + " tiene el nombre --> " + aux.nextElement().getNombre());			
			}
		}		
	}
	
	/**
	 * Método validar valida un DNI llamando a las dos validaciones validarNumeros y validarLetraDNI
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
		 * Método validarNumeros valida los números de un DNI
		 * @return true or false si todas las posiciones de 0 a 8 son numeros
		 */
	public static boolean validarNumeros(String dni) {
		
		List <String> listaNumeros = new ArrayList<> ();
		StringBuilder miDNI = new StringBuilder("");
					
		for (int i = 0; i < 10; i++)
			listaNumeros.add(String.valueOf(i));			
		for(int  i = 0; i<dni.length()-1; i++) {
			for (String string : listaNumeros) {
				if(dni.substring(i,i+1).equals(string))
				miDNI.append(string);				
			}
		}					
		if(miDNI.length()!=8)
			return false;
		else
			return true;
}

	
		
/**
 * Método calcularLetraDNI calcula la letra del DNI
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
