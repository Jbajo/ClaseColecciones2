package com.cice.main;

import java.util.Hashtable;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cice.modelo.TablaContactos;
import com.cice.negocio.Gestora;

@SpringBootApplication
public class EjercicioColecciones2Application {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(EjercicioColecciones2Application.class, args);
		
		Gestora gestora = new Gestora();
		gestora.showMenu();
		
		
	}
}
