package com.example.demo;

import java.util.ArrayList;

/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class ValidadorDNI {
	
	public ValidadorDNI(String dni) {
		super();
	}
/**
 * 
 * @return true or false si el DNI es correcto
 */
	public static boolean validar(String dni) {
		
		String letraMayuscula="";
		
		if(dni.length()!=9||!Character.isLetter(dni.charAt(8)))
			return false;
		
		letraMayuscula = dni.substring(8).toUpperCase();
		
		if(ValidadorDNI.validarNumeros(dni) && ValidadorDNI.calcularLetraDNI(dni).equals(letraMayuscula))
			
			return true;
		else		
			return false;
	}
		/**
		 * 
		 * @return true or false si todas las posiciones de 0 a 8 son numeros
		 */
		public static boolean validarNumeros(String dni) {
			
			ArrayList <String> listaNumeros = new ArrayList<> ();
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
	
	
	
	

