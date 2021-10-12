package eda21;

import java.util.ArrayList;

public class Actor {
	private String nombre;
	private String apellido;
	private ArrayList<Pelicula> listaPeli;
	
	public Actor(String pNombre,String pApellido) {
		this.nombre= pNombre;
		this.apellido=pApellido;
		this.listaPeli= new ArrayList<Pelicula>();
	}
	
	public ArrayList<Pelicula> devolverPelisDelActor(){
		return this.listaPeli;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	public String getApellido() {
		return this.apellido;
	}
	
	public boolean tienePeli(Pelicula pPeli) {
		return this.listaPeli.contains(pPeli);
	}
	
	public void anadirPeli (Pelicula pPeli) {
		this.listaPeli.add(pPeli);
	}
}
