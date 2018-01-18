package com.cice.negocio;

import java.util.Scanner;

import com.cice.modelo.TablaContactos;

public class Gestora {
	
	private TablaContactos tabla = new TablaContactos();
	
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
	
	private void aniadirContacto() {
		Scanner sc = new Scanner (System.in);
		String dni;
		String nombre;
		
		System.out.println("Introduzca un DNI");
		dni=sc.next();					
		if(TablaContactos.validar(dni)) {
			sc.nextLine();//limpiamos el buffer
			System.out.println("Introduzca un nombre");
			nombre=sc.nextLine();					
			if(tabla.aniadirContacto(dni, nombre)) {
				System.out.println("Contacto añadido...");
			}
			else {
				System.out.println("Contacto ya existente");
			}
		}
		else {
			System.out.println("DNI erroneo");
		}
		
	}
	
	private void eliminarContacto() {
		Scanner sc = new Scanner (System.in);
		String dni;		
		
		System.out.println("Introduzca un DNI");					
		dni=sc.next();
		if(tabla.eliminarContacto(dni)) {
			System.out.println("Elemento eliminado");
		}
		else {
			System.out.println("DNI ERRONEO");
		}
	}
}
