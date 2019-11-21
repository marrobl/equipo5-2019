package es.uva.inf.tds.pr2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestNoticiaTDD {

	@Test
	@Tag("TDD")
	public void testTDDConstructorNoticia() {
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		assertEquals("Titular", noticia.getTitular());
		assertEquals(LocalDate.of(2012, 12, 12),noticia.getFecha());
		assertEquals("Fuente de la noticia",  noticia.getFuente());
		assertEquals("URL de la noticia", noticia.getURL());
		assertEquals(CategoriaNoticia.NACIONAL,noticia.getCategoria());
		
	}

	@Test
	@Tag("TDD")
	public void testTDDConstructorNoticiaFalla() {
		LocalDate fecha = LocalDate.of(2012, 12, 12);		
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia(null, fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("TDD")
	public void testTDDComparaNoticiasIguales() {
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia1 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		LocalDate fecha2 = LocalDate.of(2012, 12, 12);
		Noticia noticia2 = new Noticia("Titular", fecha2, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		assertEquals(0,noticia1.comparaNoticia(noticia2));
		fail("Not yet implemented");
	}
	
	@Test
	@Tag("TDD")
	public void testTDDComparaNoticiasFalla() {
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		assertThrows(IllegalArgumentException.class, () ->noticia.comparaNoticia(null));
	}
	
	@Test
	@Tag("TDD")
	public void testTDDNoticiasSimilares(){
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia1 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertTrue(noticia1.similar(noticia2));
	}
	
	@Test
	@Tag("TDD")
	public void testTDDNoticiasSimilaresFalla(){
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
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
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("Titular", fecha, null, "URL de la noticia", CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaURLNull(){
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("Titular", fecha,  "Fuente de la noticia", null, CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaCategoriaNull(){
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("Titular", fecha,  "Fuente de la noticia", "URL de la noticia", null);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaTitularLargo(){
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("Una dos tres cuatro cinco seis siete ocho nueve diez once doce trece", fecha,  "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiaTitularVacio(){
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Noticia noticia = new Noticia("", fecha,  "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testCompararNoticiaAnterior(){
		LocalDate antigua = LocalDate.of(2012, 12, 12);
		LocalDate actual = LocalDate.of(2012, 12, 24);
		Noticia noticia1 = new Noticia("Titular", antigua, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular", actual, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertEquals(-1, noticia1.similar(noticia2));
	}
	
	@Test
	@Tag("BlackBox")
	public void testCompararNoticiaPosterior(){
		LocalDate antigua = LocalDate.of(2012, 12, 12);
		LocalDate actual = LocalDate.of(2012, 12, 24);
		Noticia noticia1 = new Noticia("Titular", actual, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular", antigua, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertEquals(1, noticia1.similar(noticia2));
	}
	 
	@Test
	@Tag("BlackBox")
	public void testNoticiasSimilaresCategoriaTitular(){
		LocalDate fecha = LocalDate.of(2012, 12, 24);
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
		LocalDate fecha = LocalDate.of(2012, 12, 24);
		Noticia noticia1 = new Noticia("Titular 1", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular 2", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);	
		assertFalse(noticia1.similar(noticia2));
		fail("Not yet implemented");
	}
	
	@Test
	@Tag("BlackBox")
	public void testNoticiasSimilaresFallaCategoria(){
		LocalDate fecha = LocalDate.of(2012, 12, 24);
		Noticia noticia1 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);
		Noticia noticia2 = new Noticia("Titular", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.INTERNACIONAL);	
		assertFalse(noticia1.similar(noticia2));
		fail("Not yet implemented");
	}
}
