import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Iterator;

public class CatalogoPelis {
	private ArrayList<Pelicula> listaPelis;
	private static CatalogoPelis miCatalogoPelis=null;
	private HashMap<String,Pelicula> mapaPelis;

		
	private CatalogoPelis(){ 
		this.listaPelis= new ArrayList<Pelicula>();
		this.mapaPelis= new HashMap<String,Pelicula>(); 
	}
			
		
	public static synchronized CatalogoPelis getCatalogoPelis(){
		if(CatalogoPelis.miCatalogoPelis==null) {
			miCatalogoPelis=new CatalogoPelis();
		}
		return (CatalogoPelis.miCatalogoPelis);
	}
	
	
	public void incrementarDineroPeli (String pTitulo,double pCant) {
		Pelicula peli = this.buscarPeli(pTitulo);
		if (pCant>=0) {
			peli.incrementarDineroRec(pCant);
		}else {
			System.out.println("La cantidad de dinero introducida no es positiva");
		}
	}
	
	
	private Pelicula buscarPeli (String pTitulo) {
		Pelicula peli = this.mapaPelis.get(pTitulo);
		return peli;
	}
	
	public ArrayList<Actor> devolverActoresPeli (String pTitulo){//si la pelicula no esta en el catalogo se devulve una lista vacia y si esta y no tiene actores tambien sera vacia
		Pelicula peli= this.buscarPeli (pTitulo);
		ArrayList<Actor> listaAct=new ArrayList<Actor>();
		if (peli!=null) {
			listaAct=peli.devolverActoresDePeli();
		}
		return listaAct;
	}

	
	public void insertarPeli(Pelicula pPeli) {
		if(pPeli!=null) {
			this.mapaPelis.put(pPeli.getTitulo(),pPeli);
			this.listaPelis.add(pPeli);
			ArrayList<Actor> listaA= pPeli.devolverActoresDePeli();
			Iterator<Actor> itr=listaA.iterator();
			Actor act=null;
			while(itr.hasNext()) {
				act=itr.next();
				if (!act.tienePeli(pPeli)) {
					act.anadirPeli(pPeli);
				}
			}
		}
	}
	
	
}
