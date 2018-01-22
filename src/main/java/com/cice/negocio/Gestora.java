package com.cice.negocio;

import java.util.Scanner;

import com.cice.modelo.Contacto;
import com.cice.modelo.TablaContactos;

/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */

public class Gestora {
	
	private TablaContactos tabla;
	
	public Gestora(TablaContactos tabla) {
		this.tabla =  tabla;
	}
	
	public Gestora() {
		this.tabla =  new TablaContactos();
	}
	/**
	 * Método showMenu Menú de la aplicación
	 */
	public void showMenu() {
		Scanner sc = new Scanner (System.in);
		int opcion = 0;		
		
		do {
			System.out.println("------------------------------------");
			System.out.println("Añadir un contacto --> (1)");
			System.out.println("Eliminar un contacto --> (2)");
			System.out.println("Mostrar contactos --> (3)");
			System.out.println("Salir --> (0)");			
			System.out.println("------------------------------------");
			opcion = sc.nextInt();
			
			controles (opcion);			
		}while (opcion!=0);
		sc.close();
	}
	
	/**
	 * Método controles invoca a los distintos métodos
	 * @param opcion seleccionada
	 */
	private void controles (int opcion) {
		
		switch(opcion) {
		case 1:
			aniadirContacto();			
			break;					
		case 2:
			eliminarContacto();
			break;
		case 3:
			tabla.imprimirContactos();
			break;
		case 0:
			System.out.println("Saliendo del programa....");
			break;
		default:
			System.out.println("Opcion no valida...");
			break;					
	
		}

	}
	
	/**
	 * Método aniadirContacto agrega un contacto comprobando que el DNI no sea erróneo
	 * y el contacto no exista previamente
	 */
	private void aniadirContacto() {
		Scanner sc = new Scanner (System.in);		
		String respuesta = "";
		Contacto contacto;
		
		do {
			contacto = new Contacto();
			System.out.println("Introduzca un DNI");
			contacto.setDni(sc.nextLine());				
			if(TablaContactos.validar(contacto.getDni())) {			
				System.out.println("Introduzca un nombre");				
				contacto.setNombre(sc.nextLine());
				if(tabla.aniadirContacto(contacto.getDni(), contacto)) 
					System.out.println("Contacto añadido...");
				else 
					System.out.println("Contacto ya existente...");
			}
			else 
				System.out.println("DNI ERRONEO...");			
			System.out.println("¿Quieres crear otro Contacto (s/n)");
			respuesta=sc.nextLine();			
		}while(respuesta.equals("s"));
		
	}
	
	/**
	 * Método eliminarContacto elimina un contacto del HashTable comprobando el DNI
	 */
	
	private void eliminarContacto() {
		Scanner sc = new Scanner (System.in);
		String dni;		
		
		System.out.println("Introduzca un DNI");					
		dni=sc.next();		
		if(tabla.eliminarContacto(dni)==0)
			System.out.println("Elemento eliminado");		
		else if (tabla.eliminarContacto(dni)==1) 
			System.out.println("DNI ERRONEO...");		
		else
			System.out.println("Debe añadir un Contacto primero...");
	}
}
