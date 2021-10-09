import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private static Menu miMenu=null;
	
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
}
