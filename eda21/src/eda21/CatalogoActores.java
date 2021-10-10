import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CatalogoActores {
	private ArrayList<Actor> listaActores;
	private static CatalogoActores miCatalogoActores=null;
	private HashMap<String,Actor> mapaActores;

	
	private CatalogoActores(){ 
		this.listaActores= new ArrayList<Actor>();
		this.mapaActores= new HashMap<String,Actor>(); //el string esta formado por el nombre y el apellido del actor separados por un espacio
	}
		
	
	public static synchronized CatalogoActores getCatalogoActores(){
		if(CatalogoActores.miCatalogoActores==null) {
			miCatalogoActores=new CatalogoActores();
		}
		return (CatalogoActores.miCatalogoActores);
	}
	
	public ArrayList<Pelicula> devolPelisDelActor(String pNombreActor,String pApellidoActor){
		Actor actor= this.buscarActor(pNombreActor,pApellidoActor);
		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
		if (actor!=null) {
			lista = actor.devolverPelisDelActor();
		}
		return lista;
	}
	
	public Actor buscarActor(String pNombreActor,String pApellidoActor) {
		Actor actor= this.mapaActores.get(pNombreActor+" "+pApellidoActor);
		if (actor==null) {
			System.out.println("No existe ese actor");
		}
		return actor;
	}
	
	
	public void insertarActor (Actor pActor) { //precondicion:el actor no esta en el catalogo y las pelis ya estan en el catalogo de pelis 
		if(pActor!=null) {
			this.mapaActores.put(pActor.getNombre()+" "+pActor.getApellido(),pActor);
			this.listaActores.add(pActor);
			ArrayList<Pelicula> listaP= pActor.devolverPelisDelActor();
			Iterator<Pelicula> itr=listaP.iterator();
			Pelicula peli=null;
			while(itr.hasNext()) {
				peli=itr.next();
				if (!peli.estaElActorEnLaPeli(pActor)) {
					peli.anadirActor(pActor);
				}
			}
		}
	}
	
	
	public void borrarActor (Actor pActor) { //precondicion:el actor esta en el catalogo 
		if(pActor!=null) {
			this.mapaActores.remove(pActor.getNombre()+" "+pActor.getApellido());
			this.listaActores.remove(pActor);
			ArrayList<Pelicula> listaP= pActor.devolverPelisDelActor();
			Iterator<Pelicula> itr=listaP.iterator();
			Pelicula peli=null;
			while(itr.hasNext()){
				peli=itr.next();
				peli.devolverActoresDePeli().remove(pActor);
			}
		}
	}
	
	/*public ArrayList<Actor> ordenarCatalogoActores(){
		
	}*/
	
	
	/*private {
		para hacer el quicksort
	}*/
	
}
