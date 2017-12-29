package com.example.demo;

import java.util.Hashtable;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioColecciones2Application {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(EjercicioColecciones2Application.class, args);
		
		TablaContactos tabla = new TablaContactos();		
		int opcion = 1;
		String dni = new String();
		String nombre = new String();
		Scanner sc = new Scanner (System.in);
		
		do {
			System.out.println("--------------------------");
			System.out.println("Añadir un contacto --> (1)");
			System.out.println("Eliminar un contacto --> (2)");
			System.out.println("Mostrar contactos --> (3)");
			System.out.println("Salir --> (0)");
			System.out.println("--------------------------");
			opcion = sc.nextInt();
					
			switch(opcion) {
				case 1:
					System.out.println("Introduzca un DNI");
					dni=sc.next();					
					if(ValidadorDNI.validar(dni)) {
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
					break;					
				case 2:
					System.out.println("Introduzca un DNI");					
					dni=sc.next();
					if(tabla.eliminarContacto(dni)) {
						System.out.println("Elemento eliminado");
					}
					else {
						System.out.println("DNI ERRONEO");
					}
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
			
		}while(opcion!=0);	
		
		
	}
}
