package es.uva.inf.tds.pr2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Clase de test secuencia para la clase BoletinNoticia
 * @author silmont
 * @author marrobl
 *
 */
public class BoletinNoticiaTestSecuencia {

	private BoletinNoticia boletin;
	
	@Test
	@Tag("Secuencia")
	void testBoletinNoticiaVacio() {
		boletin = new BoletinNoticia();
		assertEquals(boletin.getNumNoticias(), 0);
	}
	
	@Test
	@Tag("Secuencia")
	void testAnadirNoticiaBoletin() {
		boletin = new BoletinNoticia();
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia1 = new Noticia("Titular 1", fecha, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.INTERNACIONAL);
		boletin.addNoticia(noticia1);
		assertTrue(boletin.contieneNoticia(noticia1));
	}
	
	
	
}
