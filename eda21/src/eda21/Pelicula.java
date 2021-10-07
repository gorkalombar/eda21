import java.util.ArrayList;
import java.util.Iterator;

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
	
	public ArrayList<Actor> devolverActoresDePeli(){
		return this.listaActor;
	}
}
