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

}
