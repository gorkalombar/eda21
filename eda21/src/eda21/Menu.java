package eda21;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
			String[] arrayActores;
			String[] arrayDatos;
			String[] arrayAct;

			while (entrada.hasNext()) {
				linea = entrada.nextLine();								//Linea es un string que es cada linea de texto
				arrayDatos = linea.split("--->>>");
				arrayActores = arrayDatos[1].split("#####");
				Pelicula peli= new Pelicula(arrayDatos[0]);
				if (CatalogoPelis.getCatalogoPelis().buscarPeli(arrayDatos[0])==null) {
					CatalogoPelis.getCatalogoPelis().insertarPeli(peli);
				}

				for(int i=0; i< arrayActores.length; i++) {				//for(String s : arrayActores) {
					arrayAct = arrayActores[i].split(", ");
					String apellido=arrayAct[0];
					String nombre=arrayAct[1];
					Actor actor = new Actor(nombre, apellido);
					if (CatalogoActores.getCatalogoActores().buscarActor(nombre, apellido)==null) {
						CatalogoActores.getCatalogoActores().insertarActor(actor);
					}
					if(!peli.estaElActorEnLaPeli(actor)) {
						peli.anadirActor(actor);
					}
				}
			}
			entrada.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}

	public void guardarEnFichero(String nomF) throws IOException {
		String dirActual = System.getProperty("user.dir");				//Averiguar ruta
		String pathOut = dirActual + File.separator + nomF + ".txt";	//Establecer ruta guardado

		FileWriter fichero = null;
		PrintWriter pw = null;

		fichero = new FileWriter(pathOut, true);	// true: modo append
		pw = new PrintWriter(fichero);

		for(int i=0; i<10; i++) {
			pw.println();
		};
		pw.close();

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

		while (selec<0 && selec>9) {
			System.out.println("Introduzca un numero válido.");
			selec = keyboard.nextInt();
		};

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
			System.out.println("Introduzca el NOMBRE del actor/actriz a anadir:");
			String nomAct2= keyboard.nextLine();
			System.out.println("Introduzca el APELLIDO del actor/actriz a anadir:");
			String apeAct2= keyboard.nextLine();
			Actor actorAAnadir=new Actor(nomAct2, apeAct2);
			CatalogoActores.getCatalogoActores().insertarActor(actorAAnadir);

		} else if (selec==3) {//Obetener las peliculas de un actor/actriz
			System.out.println("Introduzca el NOMBRE del actor/actriz a buscar:");
			String nomAct3= keyboard.nextLine();
			System.out.println("Introduzca el APELLIDO del actor/actriz a buscar:");
			String apeAct3= keyboard.nextLine();
			CatalogoActores.getCatalogoActores().devolPelisDelActor(nomAct3, apeAct3);

		} else if (selec==4) {//Obtener los actores/actrices de una pelicula
			System.out.println("Introduzca el nombre de la pelicula a buscar:");
			String nomPeli4= keyboard.nextLine();
			CatalogoPelis.getCatalogoPelis().devolverActoresPeli(nomPeli4);

		} else if (selec==5) {//Incrementar la recaudacion de una pelicula
			System.out.println("Introduzca el nombre de la pelicula cuya recaudación quiere aumentar:");
			String nomPeli5= keyboard.nextLine();
			System.out.println("Introduzca la cantidad de dinero que quiere anadir (admite decimales):");
			Double cant= keyboard.nextDouble();
			CatalogoPelis.getCatalogoPelis().incrementarDineroPeli(nomPeli5, cant);

		} else if (selec==6) {//Eliminar actor/actriz
			System.out.println("Introduzca el NOMBRE del actor/actriz a eliminar:");
			String nomAct2= keyboard.nextLine();
			System.out.println("Introduzca el APELLIDO del actor/actriz a eliminar:");
			String apeAct2= keyboard.nextLine();
			Actor actorABorrar=new Actor(nomAct2, apeAct2);
			CatalogoActores.getCatalogoActores().borrarActor(actorABorrar);

		} else if (selec==7) {//Guardar los datos en un fichero
			System.out.println("Introduzca el nombre del fichero para guardar:");
			String nomF7= keyboard.nextLine();
			this.guardarEnFichero(nomF7);

		} else if (selec==8) {//Obtener lista ordenada de actores
			CatalogoActores.getCatalogoActores().quickSort();

		} else if (selec==9) {//Finalizar programa
			System.exit(0);
		};
	}
}