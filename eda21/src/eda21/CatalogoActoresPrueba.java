

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogoActoresPrueba {
	static Actor a1;
	static Actor a2;
	static Actor a3;
	static Actor a4;
	static Actor a0;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a1=new Actor("Andrea", "Lopez");
		a2=new Actor("Benito", "Camela");
		a3=new Actor("Unachi", "Camala");
		a4=new Actor("Elsa", "Pato");
		a0=new Actor ("Andrea", "Martinez");
		
		CatalogoActores ca =CatalogoActores.getCatalogoActores();
		
		ca.insertarActor(a0);
		ca.insertarActor(a1);
		ca.insertarActor(a2);
		ca.insertarActor(a3);
		ca.insertarActor(a4);
		
		
		
		ArrayList<Actor> listaOrdenada =ca.quickSort();
		Iterator<Actor> itr = listaOrdenada.iterator(); 
		while(itr.hasNext()){ 
			Actor a = itr.next(); 
			a.imprimirDatos(); 
		}
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	
	}



	@Test
	void test() {
		fail("Not yet implemented");
	}

}
