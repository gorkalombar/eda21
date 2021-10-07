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
	
	

	
}
