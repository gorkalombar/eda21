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
	
	public ArrayList<Actor> quickSort(){
		ArrayList<Actor> duplicado = new ArrayList<>(listaActores);
		quickSort(duplicado,0,duplicado.size()-1);
		return duplicado;
	}
	
	
	private void quickSort (ArrayList<Actor> listaActores,int ini,int fin) {
		if(fin-ini>0){
			int indPart=particion(listaActores,ini,fin);
			quickSort(listaActores,ini,indPart-1);
			quickSort(listaActores,indPart+1,fin);
		}
	}
		
	private int particion (ArrayList<Actor> listaActores, int i, int f){
		Actor pivote=listaActores.get(i); 
		int izq=i;
		int der=f;
		
		while (izq<der) {
			while(listaActores.get(izq).compareTo(pivote)<=0 && izq<der) {
				izq++;
			}
			while (listaActores.get(der).compareTo(pivote)>0 ) {
				der--;
			}
			if (izq<der) {
				swap (listaActores,izq,der);
			}
		}
		listaActores.set(i,listaActores.get(der));
		listaActores.set(der,pivote);
		
		return der;
	}
	
	private void swap (ArrayList<Actor> listaActores, int izq, int der) {
		Actor actorizq = listaActores.get(izq);
		Actor actorder = listaActores.get(der);
		
		listaActores.set(izq,actorder);
		listaActores.set(der,actorizq);
	}
	
	public void imprimirInfoActores(){ 
		Iterator<Actor> itr = listaActores.iterator(); 
		while(itr.hasNext()){ 
			Actor a = itr.next(); a.imprimirDatos(); 
		} 
	}
	
	
	
		
	
	
}
