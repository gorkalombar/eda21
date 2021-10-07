import java.util.ArrayList;

public class Actor {
	private String nombre;
	private ArrayList<Pelicula> listaPeli;
	
	public Actor(String pNombre) {
		this.nombre= pNombre;
		this.listaPeli= new ArrayList<Pelicula>();
	}
	
	public ArrayList<Pelicula> devolverPelisDelActor(){
		return this.listaPeli;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
