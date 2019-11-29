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
	private BoletinNoticia boletinVacio;
	private Noticia noticia1, noticia2, noticia3, noticia4;
	
	@BeforeEach
	void setUp() {
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		noticia1 = new Noticia("Titular 1", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.INTERNACIONAL);
		noticia2 = new Noticia("Titular 2", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		noticia3 = new Noticia("Titular 1", fecha2, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.DEPORTE);
		LocalDate fecha3 = LocalDate.of(2011, 11, 11);
		noticia4 = new Noticia("Titular 2", fecha3, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.CULTURA);	
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticia1);
		listaNoticias.add(noticia2);
		listaNoticias.add(noticia3);
		listaNoticias.add(noticia4);
		boletin = new BoletinNoticia(listaNoticias);
		boletinVacio = new BoletinNoticia();
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
		assertArrayEquals(boletin.getListaNoticias().toArray(), arrayNoticias);
		assertNotNull(boletin.getListaNoticias());
		
	}
	
	@Test
	@Tag("TDD")
	void testTDDConstructorVacioBoletinNoticia() {
		BoletinNoticia boletin = new BoletinNoticia();
		assertNull(boletin.getListaNoticias());
	}
	
	@Test 
	void testTDDContieneNoticia() {
		assertTrue(boletin.contieneNoticia(noticia1));
	}
	
	@Test
	void testTDDContieneNoticiaNull() {
		assertThrows(IllegalArgumentException.class, () ->boletin.contieneNoticia(null));
	}
	
	@Test 
	void testTDDAgregarNoticia() {
		BoletinNoticia boletin = new BoletinNoticia();
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		boletin.addNoticia(noticia);
		assertTrue(boletin.contieneNoticia(noticia));
	}
	
	@Test
	void testTDDAgregarNoticiaNull() {
		assertThrows(IllegalArgumentException.class, () ->boletinVacio.addNoticia(null));
	}
	
	@Test 
	void testTDDgetNumNoticias() {
		BoletinNoticia boletin = new BoletinNoticia();
		assertEquals(boletin.getNumNoticias(), 0);
	}
	
	@Test
	void testTDDgetOrdenadasFecha() {
		Noticia[] arrayNoticiasOrdenada = {noticia4, noticia1, noticia2, noticia3};
		Noticia[] arrayComprobar = new Noticia[boletin.getNoticiasOrdenadas().size()];
		arrayComprobar = boletin.getNoticiasOrdenadas().toArray(arrayComprobar);
		assertArrayEquals(arrayComprobar,arrayNoticiasOrdenada);
	}
	
	@Test
	void testTDDgetOrdenadasCategoria() {
		Noticia[] arrayNoticiasOrdenada = {noticia2, noticia1, noticia3, noticia4};
		Noticia[] arrayComprobar = new Noticia[boletin.getNoticiasOrdenadasCategoria().size()];
		arrayComprobar = boletin.getNoticiasOrdenadasCategoria().toArray(arrayComprobar);
		assertArrayEquals(arrayComprobar,arrayNoticiasOrdenada);
	}
	
	@Test
	void testTDDgetFechaNoticiasRecientes() {
		LocalDate fechaAcomparar = LocalDate.of(2014, 05, 05);
		assertEquals(boletin.getFechaNoticiasRecientes(), fechaAcomparar);
		
	}
	
	@Test
	void testTDDgetFechaNoticiasRecientesExcepcion() {
		assertThrows(IllegalStateException.class, () ->boletinVacio.getFechaNoticiasRecientes());
		
	}
	
	@Test
	void testTDDgetFechaNoticiasAntiguas() {
		LocalDate fechaAcomparar = LocalDate.of(2011, 11, 11);
		assertEquals(boletin.getFechaNoticiasAntiguas(), fechaAcomparar);
		
	}
	
	@Test
	void testTDDgetFechaNoticiasAntiguasExcepcion() {
		assertThrows(IllegalStateException.class, () ->boletinVacio.getFechaNoticiasAntiguas());
		
	}
	
	@Test
	void testTDDgetNoticiasSimilares() {
		LocalDate fecha3 = LocalDate.of(2011, 11, 11);
		Noticia noticiaSimilar = new Noticia("Titular 1", fecha3, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.INTERNACIONAL);
		Noticia[] noticiasSimilares = {noticiaSimilar};
		assertArrayEquals(boletin.getNoticiasSimilares(noticiaSimilar).toArray(), noticiasSimilares);
	}
	
	@Test
	void testTDDgetNoticiasSimilaresNull() {
		assertThrows(IllegalArgumentException.class, () ->boletin.getNoticiasSimilares(null));
	}
	
	@Test
	void testTDDgetSubconjuntoUnaFecha() {
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		noticias.add(noticia1);
		noticias.add(noticia2);
		BoletinNoticia subboletin = new BoletinNoticia(noticias);
		assertEquals(subboletin, boletin.getSubconjunto(fecha));
	}
	
	@Test
	void testTDDgetSubconjuntoUnaFechaNull() {
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(null));
	}

}
