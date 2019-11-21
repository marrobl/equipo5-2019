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
		assertThrows(IllegalArgumentException.class, () -> {Noticia noticia = new Noticia(null, fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.NACIONAL);});
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
		assertThrows(IllegalArgumentException.class, () -> noticia.comparaNoticia(null));
	}
	
}
