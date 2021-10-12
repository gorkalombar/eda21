package eda21;

import java.util.ArrayList;


public class Pelicula {
	private String titulo;
	private double dineroRec;
	private ArrayList<Actor> listaActor;
	
	public Pelicula(String pTitulo) {
		this.titulo=pTitulo;
		this.dineroRec=0;
		this.listaActor= new ArrayList<Actor>();
	}
	
	public void incrementarDineroRec(double pCant) {
		this.dineroRec=this.dineroRec + pCant;
	}
	public double getDineroRec() {
		return this.dineroRec;
	}
	
	public ArrayList<Actor> devolverActoresDePeli(){
		return this.listaActor;
	}
	
	public boolean estaElActorEnLaPeli(Actor pActor) {
		return this.listaActor.contains(pActor);
	}
	
	public void anadirActor (Actor pActor) {
		this.listaActor.add(pActor);
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	
}
