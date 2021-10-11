//package eda21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		ArrayList<Pelicula> listaPrueba1;
		ArrayList<Pelicula> listaPrueba2;
		ArrayList<Pelicula> listaPrueba3;
		listaPrueba1= new ArrayList<Pelicula>();
		listaPrueba2= new ArrayList<Pelicula>();
		listaPrueba3= new ArrayList<Pelicula>();
		
		listaPrueba1.add(p1);
		assertEquals(a1.devolverPelisDelActor(), listaPrueba1);
		
		listaPrueba2.add(p1);
		listaPrueba2.add(p2);
		assertEquals(a2.devolverPelisDelActor(), listaPrueba2);
		
		listaPrueba3.add(p1);
		listaPrueba3.add(p3);
		assertEquals(a3.devolverPelisDelActor(), listaPrueba3);
	}

	@Test
	void testGetNombre() {
		assertEquals("Andrea", a1.getNombre());
		assertEquals("Benito", a2.getNombre());
		assertEquals("Unachi", a3.getNombre());
		
		assertNotEquals("Pereda", a1.getNombre());
	}

	@Test
	void testGetApellido() {
		assertEquals("Lopez", a1.getApellido());
		assertEquals("Camela", a2.getApellido());
		assertEquals("Camala", a3.getApellido());
		
		assertNotEquals("Pereda", a1.getApellido());
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
