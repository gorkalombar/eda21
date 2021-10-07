import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CatalogoActores {
	private ArrayList<Actor> listaActores;
	private static CatalogoActores miCatalogoActores=null;
	private HashMap<String,Actor> mapaActores;

	
	private CatalogoActores(){ 
		this.listaActores= new ArrayList<Actor>();
		this.mapaActores= new HashMap<String,Actor>(); 
	}
		
	
	public static synchronized CatalogoActores getCatalogoActores(){
		if(CatalogoActores.miCatalogoActores==null) {
			miCatalogoActores=new CatalogoActores();
		}
		return (CatalogoActores.miCatalogoActores);
	}
	
	public ArrayList<Pelicula> devolPelisDelActor(String pNombreActor){
		Actor actor= this.buscarActor(pNombreActor);
		ArrayList<Pelicula> lista = new ArrayList();
		if (actor!=null) {
			lista = actor.devolverPelisDelActor();
		}
		return lista;
	}
	
	public Actor buscarActor(String pNombreActor) {
		Actor actor= this.mapaActores.get(pNombreActor);
		if (actor==null) {
			System.out.println("No existe ese actor");
		}
		return actor;
	}
	
	
	public void insertarActor (Actor pActor) { //precondicion:el actor no esta en el catalogo y las pelis ya estan en el catalogo de pelis 
		if(pActor!=null) {
			this.mapaActores.put(pActor.getNombre(),pActor);
			this.listaActores.add(pActor);
			//CatalogoPelis.anadirActorASusPelis (pAc);
		}
	}
	
	
	
}
