package com.example.demo;

import java.util.ArrayList;

/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class ValidadorDNI {
	
	private String dni;	
	
	
	public ValidadorDNI(String dni) {
		super();
		this.dni = new String(dni);
	}
/**
 * 
 * @return true or false si el DNI es correcto
 */
	public boolean validar() {
		
		String letraMayuscula="";
		
		if(this.dni.length()!=9||!Character.isLetter(this.dni.charAt(8)))
			return false;
		
		letraMayuscula = this.dni.substring(8).toUpperCase();
		
		if(validarNumeros() && calcularLetraDNI().equals(letraMayuscula))
			
			return true;
		else		
			return false;
	}
		/**
		 * 
		 * @return true or false si todas las posiciones de 0 a 8 son numeros
		 */
		public boolean validarNumeros() {
			
			ArrayList <String> listaNumeros = new ArrayList<> ();
			final String [] miDNI = new String [] {""};
						
			for (int i = 0; i < 10; i++)
				listaNumeros.add(String.valueOf(i));
			
			
			for(final int [] i = new int [] {0}; i[0]<this.dni.length()-1;i[0]++) {
				listaNumeros.forEach(k->{
					if(this.dni.substring(i[0], i[0]+1).equals(k))
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
		public String calcularLetraDNI() {
			int miDNI = Integer.parseInt(this.dni.substring(0,8));
			int resto = 0;
			String letra = "";
			String [] asignacionLetra = {"T", "R", "W", "A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
			
			resto = miDNI%23;
			letra = asignacionLetra[resto];
			return letra;
		
		}
			


}
	
	
	
	

