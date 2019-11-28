package es.uva.inf.tds.pr2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;


import org.junit.jupiter.api.Tag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoletinNoticiaTDDTest {
	private BoletinNoticia boletin;
	private Noticia noticia1, noticia2, noticia3, noticia4;
	
	@BeforeEach
	void setUp() {
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		noticia1 = new Noticia("Titular 1", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		noticia2 = new Noticia("Titular 2", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		noticia3 = new Noticia("Titular 1", fecha2, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		LocalDate fecha3 = LocalDate.of(2011, 11, 11);
		noticia4 = new Noticia("Titular 2", fecha3, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticia1);
		listaNoticias.add(noticia2);
		listaNoticias.add(noticia3);
		listaNoticias.add(noticia4);
		boletin = new BoletinNoticia(listaNoticias);
	}
	
	@Test
	@Tag("TDD")
	void testTDDConstructorBoletinNoticia() {
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia1 = new Noticia("Titular 1", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular 2", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticia1);
		listaNoticias.add(noticia2);
		BoletinNoticia boletin = new BoletinNoticia(listaNoticias);
		Noticia[] arrayNoticias = new Noticia[listaNoticias.size()];
		arrayNoticias = listaNoticias.toArray(arrayNoticias);
		fail("Not yet implemented");
		assertArrayEquals(boletin.getListaNoticias().toArray(), arrayNoticias);
		assertNotNull(boletin.getListaNoticias());
		
	}
	
	@Test
	@Tag("TDD")
	void testTDDConstructorVacioBoletinNoticia() {
		BoletinNoticia boletin = new BoletinNoticia();
		fail("Not yet implemented");
		assertNull(boletin.getListaNoticias());
	}
	
	@Test 
	void testTDDAgregarNoticia() {
		BoletinNoticia boletin = new BoletinNoticia();
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		boletin.addNoticia(noticia);
		fail("not yet implemented");
		assertTrue(boletin.getListaNoticias().contains(noticia));
	}
	
	@Test
	void testTDDAgregarNoticiaNull() {
		BoletinNoticia boletin = new BoletinNoticia();
		assertThrows(IllegalArgumentException.class, () ->boletin.addNoticia(null));
	}
	
	@Test 
	void testTDDgetNumNoticias() {
		BoletinNoticia boletin = new BoletinNoticia();
		fail("Not yet implemented");
		assertEquals(boletin.getNumNoticias(), 0);
	}
	
	@Test
	void testTDDgetOrdenadasFecha() {
		ArrayList<Noticia> listaNoticiasOrdenada = new ArrayList<Noticia>();
		listaNoticiasOrdenada.add(noticia4);
		listaNoticiasOrdenada.add(noticia1);
		listaNoticiasOrdenada.add(noticia2);
		listaNoticiasOrdenada.add(noticia3);
		Noticia[] arrayNoticiasOrdenada = new Noticia[listaNoticiasOrdenada.size()];
		arrayNoticiasOrdenada = listaNoticiasOrdenada.toArray(arrayNoticiasOrdenada);
		Noticia[] arrayComprobar = new Noticia[boletin.getNoticiasOrdenadas().size()];
		arrayComprobar = boletin.getNoticiasOrdenadas().toArray(arrayComprobar);
		
		assertArrayEquals(arrayComprobar,arrayNoticiasOrdenada);
	}
}
