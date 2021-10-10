package eda21;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private static Menu miMenu=null;
	private static Scanner keyboard = new Scanner(System.in);	
	private Menu() {	
	}
		
	public static synchronized Menu getMenu(){
		if(Menu.miMenu==null) {
			miMenu=new Menu();
		}
		return (Menu.miMenu);
	}
	
	public void cargarFichero(String nomF){//expresiones regulares
		 try{
		 Scanner entrada = new Scanner(new FileReader(nomF));

		 String linea;
		 String titulo;
		 ArrayList<Actor> actores;
		 String[] arrayDatos;
		 while (entrada.hasNext()) {
			 linea = entrada.nextLine();
			 arrayDatos=linea.split("#####");
			 arrayDatos=linea.split("--->>>");
		 }
		 entrada.close();
		 }
		 catch(IOException e) {e.printStackTrace();}
	}
	
	public void mostrarMenuPrincipal() {
		
		System.out.println("MENU PRINCIPAL");
		System.out.println("Seleccione una de las siguiente opciones:");
		System.out.println("-0: Cargar los datos");
		System.out.println("-1: Buscar actor/actriz");
		System.out.println("-2: Añadir actor/actriz");
		System.out.println("-3: Obetener las peliculas de un actor/actriz");
		System.out.println("-4: Obtener los actores/actrices de una pelicula");
		System.out.println("-5: Incrementar la recaudacion de una pelicula");
		System.out.println("-6: Eliminar actor/actriz");
		System.out.println("-7: Guardar los datos en un fichero");
		System.out.println("-8: Obtener lista ordenada de actores");
		System.out.println("-9: Finalizar programa");
		System.out.println("->");
		
		int selec = keyboard.nextInt();
		
		if (selec<0 && selec>9) {
			System.out.println("Introduzca un numero válido.");
			this.mostrarMenuPrincipal();
		}
		
		if(selec==0) {//Cargar los datos
			System.out.println("Introduzca el nombre del fichero a cargar:");
			String nomF= keyboard.nextLine();
			this.cargarFichero(nomF);
			this.mostrarMenuPrincipal();
		} else if (selec==1) {//Buscar actor/actriz
			System.out.println("Introduzca el NOMBRE del actor/actriz a buscar:");
			String nomAct= keyboard.nextLine();
			System.out.println("Introduzca el APELLIDO del actor/actriz a buscar:");
			String apeAct= keyboard.nextLine();
			CatalogoActores.getCatalogoActores().buscarActor(nomAct,apeAct);
			
		} else if (selec==2) {//Añadir actor/actriz
			
		} else if (selec==3) {//Obetener las peliculas de un actor/actriz
			
		} else if (selec==4) {//Obtener los actores/actrices de una pelicula
			
		} else if (selec==5) {//Incrementar la recaudacion de una pelicula
			
		} else if (selec==6) {//Eliminar actor/actriz
			
		} else if (selec==7) {//Guardar los datos en un fichero
			
		} else if (selec==8) {//Obtener lista ordenada de actores
			
		} else if (selec==9) {//Finalizar programa
			System.exit(0);
		};
	}
}