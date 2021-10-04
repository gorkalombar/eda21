package Laboratorio1;
import java.util.ArrayList;
import java.util.Iterator;


public class Catalogo {
	
	private ArrayList<Pelicula> listaPeli;
	private static Catalogo miCatalogo=null;

	
	private Catalogo(){ 
		this.listaPeli= new ArrayList<Pelicula>();
	}
		
	
	public static synchronized Catalogo getCatalogo(){
		if(Catalogo.miCatalogo==null) {
			miCatalogo=new Catalogo();
		}
		return (Catalogo.miCatalogo);
	}

	private Iterator<Pelicula> getIterador(){
		return (this.listaPeli.iterator());
	}
	
	/*public ArrayList<Pelicula> buscarPelisDeActor(Actor pActor) {
		listaPeliculasDeActor = new ArrayList<Peliculas>();
		
		tengo que devolver un ArrayList de peliculas con los nombres de las peliculas
		en las que actua el actor
	}*/
	
	/*public listaActor buscar(Pelicula pPelicula) {
		tengo que devolver una lista de actores que la tiene la pelicula en la clase pelicula deberia hacer
		una llamada a la clase pelicula o algo asi
	}*/
	
	
}