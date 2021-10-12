package eda21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PeliculaPrueba {

	static Actor a1;
	static Actor a2;
	static Actor a3;
	static Actor a4;
	static Pelicula p1;
	static Pelicula p2;
	static Pelicula p3;
	static Pelicula p4;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a1=new Actor("Andrea", "Lopez");
		a2=new Actor("Benito", "Camela");
		a3=new Actor("Unachi", "Camala");
		a4=new Actor("Elsa", "Pato");
		
		p1=new Pelicula("Señoras feten");
		p2=new Pelicula("TLTR");
		p3=new Pelicula("Star Wars");
		p4=new Pelicula("Cumbres Borrascosas");
		
		a1.anadirPeli(p1);
		p1.anadirActor(a1);
		a2.anadirPeli(p1);
		p1.anadirActor(a2);
		a2.anadirPeli(p2);
		p2.anadirActor(a2);
		a3.anadirPeli(p1);
		p1.anadirActor(a3);
		a3.anadirPeli(p3);
		p3.anadirActor(a3);
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
	void testIncrementarDineroRec() {
		p1.incrementarDineroRec(3.2);
		assertEquals(p1.getDineroRec(), 3.2);
		
		p1.incrementarDineroRec(0.0);
		assertEquals(p1.getDineroRec(), 3.2);
	}

	@Test
	void testDevolverActoresDePeli() {
		ArrayList<Actor> listaPrueba1;
		ArrayList<Actor> listaPrueba2;
		ArrayList<Actor> listaPrueba3;
		ArrayList<Actor> listaPrueba4;
		listaPrueba1= new ArrayList<Actor>();
		listaPrueba2= new ArrayList<Actor>();
		listaPrueba3= new ArrayList<Actor>();
		listaPrueba4= new ArrayList<Actor>();
		
		listaPrueba1.add(a1);
		listaPrueba1.add(a2);
		listaPrueba1.add(a3);
		assertEquals(p1.devolverActoresDePeli(), listaPrueba1);
		
		listaPrueba2.add(a2);
		assertEquals(p2.devolverActoresDePeli(), listaPrueba2);
		
		listaPrueba3.add(a3);
		assertEquals(p3.devolverActoresDePeli(), listaPrueba3);
		
		assertEquals(p4.devolverActoresDePeli(), listaPrueba4);
		
	}

	@Test
	void testEstaElActorEnLaPeli() {
		//QUE VERGUENZA MATAME
		assertTrue(p1.estaElActorEnLaPeli(a1));
		assertTrue(p2.estaElActorEnLaPeli(a2));
		assertFalse(p4.estaElActorEnLaPeli(a1));
	}

	@Test
	void testGetTitulo() {
		assertEquals("Senoras feten", p1.getTitulo());
		assertEquals("TLTR", p2.getTitulo());
		assertEquals("Star Wars", p3.getTitulo());
		
		assertNotEquals("Cumbres Borrascosas", p1.getTitulo());
	}

}
