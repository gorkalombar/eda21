//package eda21;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActorPrueba {
	static Actor a1;
	static Actor a2;
	static Actor a3;
	static Pelicula p1;
	static Pelicula p2;
	static Pelicula p3;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a1=new Actor("Andrea", "Lopez");
		a2=new Actor("Benito", "Camela");
		a3=new Actor("Unachi", "Camala");
		
		p1=new Pelicula("Señoras feten");
		p2=new Pelicula("TLTR");
		p3=new Pelicula("Star Wars");
		
		a1.anadirPeli(p1);
		a2.anadirPeli(p1);
		a2.anadirPeli(p2);
		a3.anadirPeli(p1);
		a3.anadirPeli(p3);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		a1=null;
		a2=null;
		a3=null;
		
		p1=null;
		p2=null;
		p3=null;
		
	}


	@Test
	void testDevolverPelisDelActor() {
		
		fail("Not yet implemented");
	}

	@Test
	void testGetNombre() {
		fail("Not yet implemented");
	}

	@Test
	void testGetApellido() {
		assertEquals("Lopez",a1.getApellido());
	}

	@Test
	void testTienePeli() {
		fail("Not yet implemented");
	}

	@Test
	void testAnadirPeli() {
		fail("Not yet implemented");
	}

}
