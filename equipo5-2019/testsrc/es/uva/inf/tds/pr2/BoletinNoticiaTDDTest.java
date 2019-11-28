package es.uva.inf.tds.pr2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BoletinNoticiaTDDTest {

	@Test
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

	
}
