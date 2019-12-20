package es.uva.inf.tds.pr2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Clase de test TDD que prueba la clase BoletinNoticia
 * @author silmont
 * @author marrobl
 *
 */
public class BoletinNoticiaTDDTest {
	private BoletinNoticia boletin;
	private BoletinNoticia boletinVacio;
	private Noticia noticia1, noticia2, noticia3, noticia4;
	private ArrayList<Noticia> listaNoticias;
	
	@BeforeEach
	void setUp() {
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		noticia1 = new Noticia("Titular 1", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.INTERNACIONAL);
		noticia2 = new Noticia("Titular 2", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		noticia3 = new Noticia("Titular 1", fecha2, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.DEPORTE);
		LocalDate fecha3 = LocalDate.of(2011, 11, 11);
		noticia4 = new Noticia("Titular 2", fecha3, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.CULTURA);	
		listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticia1);
		listaNoticias.add(noticia2);
		listaNoticias.add(noticia3);
		listaNoticias.add(noticia4);

	
	}
	
	@AfterEach
	void tearDown() {
		noticia1 = null;
		noticia2 = null;	
		noticia3 = null;
		noticia4 = null;
		boletin = null;
		boletinVacio = null;
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
	void testTDDConstructorNull() {
		assertThrows(IllegalArgumentException.class, () ->boletin = new BoletinNoticia(null));
	}
	
	@Test
	@Tag("TDD")
	void testTDDConstructorVacioBoletinNoticia() {
		BoletinNoticia boletin = new BoletinNoticia();
		assertEquals(0, boletin.getListaNoticias().size());
	}
	
	@Test 
	@Tag("TDD")
	void testTDDContieneNoticia() {
		boletin = new BoletinNoticia(listaNoticias);
		assertTrue(boletin.contieneNoticia(noticia1));
	}
	
	@Test
	@Tag("TDD")
	void testTDDContieneNoticiaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		assertThrows(IllegalArgumentException.class, () ->boletin.contieneNoticia(null));
	}
	
	@Test 
	@Tag("TDD")
	void testTDDAgregarNoticia() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		boletin.addNoticia(noticia);
		assertTrue(boletin.contieneNoticia(noticia));
	}
	
	@Test
	@Tag("TDD")
	void testTDDAgregarNoticiaNull() {
		boletinVacio = new BoletinNoticia();
		assertThrows(IllegalArgumentException.class, () ->boletinVacio.addNoticia(null));
	}
	
	@Test 
	@Tag("TDD")
	void testTDDgetNumNoticias() {
		boletinVacio = new BoletinNoticia();
		assertEquals(0, boletinVacio.getNumNoticias());
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetOrdenadasFecha() {
		boletin = new BoletinNoticia(listaNoticias);
		Noticia[] arrayNoticiasOrdenada = {noticia4, noticia1, noticia2, noticia3};
		Noticia[] arrayComprobar = new Noticia[boletin.getNoticiasOrdenadas().size()];
		arrayComprobar = boletin.getNoticiasOrdenadas().toArray(arrayComprobar);
		assertArrayEquals(arrayComprobar,arrayNoticiasOrdenada);
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetOrdenadasCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		Noticia[] arrayNoticiasOrdenada = {noticia2, noticia1, noticia3, noticia4};
		Noticia[] arrayComprobar = new Noticia[boletin.getNoticiasOrdenadasCategoria().size()];
		arrayComprobar = boletin.getNoticiasOrdenadasCategoria().toArray(arrayComprobar);
		assertArrayEquals(arrayComprobar,arrayNoticiasOrdenada);
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetFechaNoticiasRecientes() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaAcomparar = LocalDate.of(2014, 05, 05);
		assertEquals(fechaAcomparar, boletin.getFechaNoticiasRecientes());
		
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetFechaNoticiasRecientesExcepcion() {
		boletinVacio = new BoletinNoticia();
		assertThrows(IllegalStateException.class, () ->boletinVacio.getFechaNoticiasRecientes());
		
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetFechaNoticiasAntiguas() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaAcomparar = LocalDate.of(2011, 11, 11);
		assertEquals(fechaAcomparar, boletin.getFechaNoticiasAntiguas());
		
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetFechaNoticiasAntiguasExcepcion() {
		boletinVacio = new BoletinNoticia();
		assertThrows(IllegalStateException.class, () ->boletinVacio.getFechaNoticiasAntiguas());
		
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetNoticiasSimilares() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha3 = LocalDate.of(2011, 11, 11);
		Noticia noticiaSimilar = new Noticia("Titular 1", fecha3, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.INTERNACIONAL);
		Noticia[] esperado = {noticia1,noticia4};
		assertArrayEquals(esperado, boletin.getNoticiasSimilares(noticiaSimilar).toArray());
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetNoticiasSimilaresNull() {
		boletin = new BoletinNoticia(listaNoticias);
		assertThrows(IllegalArgumentException.class, () ->boletin.getNoticiasSimilares(null));
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoUnaFecha() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia[] esperado = {noticia1,noticia2};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoUnaFechaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaFallo = null;
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaFallo));
	}

	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoDosFechas() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		Noticia[] esperado = {noticia1,noticia2,noticia3};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha,fecha2).getListaNoticias().toArray());
	}

	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoDosFechaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(null, fecha2));
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		Noticia[] esperado = {noticia1};
		assertArrayEquals(esperado, boletin.getSubconjunto(CategoriaNoticia.INTERNACIONAL).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoCategoriaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		CategoriaNoticia categoriaFallo = null;
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(categoriaFallo));
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoUnaFechaCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia[] esperado = {noticia1};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha,CategoriaNoticia.INTERNACIONAL).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoUnaFechaNullCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaFallo = null;
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaFallo,CategoriaNoticia.NACIONAL));
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoDosFechasCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		Noticia[] esperado = {noticia2};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha,fecha2,CategoriaNoticia.NACIONAL).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetSubconjuntoDosFechasNullCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaFallo = null;
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaFallo,fecha2,CategoriaNoticia.NACIONAL));
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetPorcentajeSimilitud() {
		boletinVacio = new BoletinNoticia();
		boletin = new BoletinNoticia(listaNoticias);
		assertEquals(boletinVacio.getPorcentajeSimilitud(boletin), 0);
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetPorcentajeSimilitudNull() {
		boletin = new BoletinNoticia(listaNoticias);
		assertThrows(IllegalArgumentException.class, () ->boletin.getPorcentajeSimilitud(null));
	}
	
	
	
}
