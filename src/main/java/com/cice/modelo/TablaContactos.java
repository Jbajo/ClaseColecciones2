package com.cice.modelo;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
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
	 * Método validar valida un DNI llamando a calcularLetraDNI
	 * @param dni a validar
	 * @return true or false si es válido
	 */
	
	public static boolean validar(String dni) {
		
		if(dni.matches("^([0-9]{8}[A-Z])")) {						
			if(TablaContactos.calcularLetraDNI(dni).equals(String.valueOf(dni.charAt(8))))			
				return true;
			else		
				return false;
		}
		return false;
	}
			
/**
 * Método calcularLetraDNI calcula la letra del DNI
 * @return letra del DNI
 */
		public static String calcularLetraDNI(String dni) {
			int DNI = Integer.parseInt(dni.substring(0,8));						
			String [] letra = {"T", "R", "W", "A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};			
			
			return letra[DNI%23];
		
		}	

}
