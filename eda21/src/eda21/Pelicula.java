package Laboratorio1;

import java.util.ArrayList;
import java.util.Iterator;

public class Pelicula {
	private double presupuesto;
	private ArrayList<Actor> listaActor;
	private String titulo;
	
	private Iterator<Actor> getIterador(){
		return (this.listaActor.iterator());
	}
	
	public double cambiarPresupuesto(double pCant) {
		this.presupuesto=this.presupuesto + pCant;
		return this.presupuesto;
	}
	
	
}