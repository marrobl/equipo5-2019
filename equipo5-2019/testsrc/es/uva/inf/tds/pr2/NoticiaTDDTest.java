package es.uva.inf.tds.pr2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class NoticiaTDDTest {
	private Noticia noticia;
	private LocalDate fecha;
	
	@BeforeEach
	public void setUp() {
		fecha = LocalDate.of(2012, 12, 12);
		noticia = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
	}

	@Test
	@Tag("TDD")
	public void testTDDConstructorNoticia() {
		assertNotNull(noticia.getTitular());
		assertNotNull(noticia.getFecha());
		assertNotNull(noticia.getFuente());
		assertNotNull(noticia.getURL());
		assertNotNull(noticia.getCategoria());
		assertEquals("Titular", noticia.getTitular());
		assertEquals(LocalDate.of(2012, 12, 12),noticia.getFecha());
		assertEquals("Fuente de la noticia",  noticia.getFuente());
		assertEquals("URL de la noticia", noticia.getURL());
		assertEquals(CategoriaNoticia.NACIONAL,noticia.getCategoria());
		
		
	}

	@Test
	@Tag("TDD")
	public void testTDDConstructorNoticiaFalla() {
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia(null, fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("TDD")
	public void testTDDComparaNoticiasIguales() {
		Noticia noticia2 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		assertEquals(0,noticia.comparaNoticia(noticia2));
		fail("Not yet implemented");
	}
	
	@Test
	@Tag("TDD")
	public void testTDDComparaNoticiasFalla() {
		Noticia noticia = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		assertThrows(IllegalArgumentException.class, () ->noticia.comparaNoticia(null));
	}
	
	@Test
	@Tag("TDD")
	public void testTDDNoticiasSimilares(){
		Noticia noticia2 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertTrue(noticia.similar(noticia2));
	}
	
	@Test
	@Tag("TDD")
	public void testTDDNoticiasSimilaresFalla(){
		assertThrows(IllegalArgumentException.class, () -> noticia.similar(null));
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaFechaNull(){
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("Titular", null, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaFuenteNull(){
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("Titular", fecha, null, "URL de la noticia", CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaURLNull(){
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("Titular", fecha,  "Fuente de la noticia", null, CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaCategoriaNull(){
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("Titular", fecha,  "Fuente de la noticia", "URL de la noticia", null);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaTitularLargo(){
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("Una dos tres cuatro cinco seis siete ocho nueve diez once doce trece", fecha,  "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaTitularVacio(){
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("", fecha,  "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testCompararNoticiaAnterior(){
		LocalDate fechaMasActual = LocalDate.of(2012, 12, 24);
		Noticia noticia2 = new Noticia("Titular", fechaMasActual, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertEquals(-1, noticia.similar(noticia2));
	}
	
	@Test
	@Tag("BlackBox")
	public void testCompararNoticiaPosterior(){
		LocalDate fechaMasActual = LocalDate.of(2012, 12, 24);
		Noticia noticia2 = new Noticia("Titular", fechaMasActual, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertEquals(1, noticia2.similar(noticia));
	}
	 
	@Test
	@Tag("BlackBox")
	public void testNoticiasSimilaresCategoriaTitular(){
		Noticia noticia1 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertTrue(noticia1.similar(noticia2));
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiasSimilaresFechasDiferenciaDosDias(){
		LocalDate fecha1 = LocalDate.of(2012, 12, 24);
		LocalDate fecha2 = LocalDate.of(2012, 12, 26);
		Noticia noticia1 = new Noticia("Titular 1", fecha1, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular 2", fecha2, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.INTERNACIONAL);	
		assertTrue(noticia1.similar(noticia2));
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiasSimilaresFallaFecha(){
		LocalDate fecha1 = LocalDate.of(2012, 12, 24);
		LocalDate fecha2 = LocalDate.of(2012, 12, 27);
		Noticia noticia1 = new Noticia("Titular", fecha1, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular", fecha2, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertFalse(noticia1.similar(noticia2));
		fail("Not yet implemented");
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiasSimilaresFallaTitular(){
		Noticia noticia1 = new Noticia("Titular 1", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular 2", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertFalse(noticia1.similar(noticia2));
		fail("Not yet implemented");
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiasSimilaresFallaCategoria(){
		Noticia noticia1 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.INTERNACIONAL);	
		assertFalse(noticia1.similar(noticia2));
		fail("Not yet implemented");
	}
}