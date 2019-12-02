package es.uva.inf.tds.pr2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BoletinNoticiaBlackBoxTest {
	
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
	@Tag("BlackBox")
	void testNoContieneNoticia() {
		LocalDate fechaPrueba = LocalDate.of(2012, 12, 12);
		Noticia noticiaPrueba = new Noticia("titular", fechaPrueba, "fuente", "url", CategoriaNoticia.CULTURA );
		assertFalse(boletin.contieneNoticia(noticiaPrueba));
		// TODO quitar en implementacion
		fail("not yet implemented");
	}
	
	@Test 
	@Tag("BlackBox")
	void testAgregarNoticiaRepetida() {
		assertThrows(IllegalArgumentException.class, () ->boletin.addNoticia(noticia1));
	}
	
	@Test
	@Tag("BlackBox")
	void testNogetNoticiasSimilares() {
		LocalDate fecha3 = LocalDate.of(2018, 11, 11);
		Noticia noticiaNoSimilar = new Noticia("Titular distinto", fecha3, "Fuente de la noticia", "URL de la noticia", CategoriaNoticia.SOCIEDAD);
		Noticia[] noticiasSimilares = {};
		assertArrayEquals(boletin.getNoticiasSimilares(noticiaNoSimilar).toArray(), noticiasSimilares);
		// TODO quitar en implementacion
		fail("not yet implemented");
	}
	
	@Test
	@Tag("BlackBox")
	void testgetSubconjuntoDosFechasDesordenadas() {
		LocalDate fechaPost = LocalDate.of(2018, 11, 11);
		LocalDate fechaAnt = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaPost,fechaAnt));
	}
	
	@Test
	@Tag("BlackBox")
	void testgetSubconjuntoDosFechasIguales() {
		LocalDate fechaPost = LocalDate.of(2018, 11, 11);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaPost,fechaPost));
	}
	
	@Test
	@Tag("BlackBox")
	void testgetSubconjuntoDosFechasSegundaNull() {
		LocalDate fechaFallo = null;
		LocalDate fechaPost = LocalDate.of(2018, 11, 11);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaPost,fechaFallo));
	}
	
	@Test
	@Tag("BlackBox")
	void testgetSubconjuntoDosFechasNullCategoria() {
		LocalDate fechaFallo = null;
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fecha2,fechaFallo,CategoriaNoticia.NACIONAL));
	}
	
	@Test
	@Tag("BlackBox")
	void testgetSubconjuntoDosFechasCategoriaNull() {
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		LocalDate fecha3 = LocalDate.of(2014, 9, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fecha2,fecha3,null));
	}
	
	@Test
	@Tag("BlackBox")
	void testgetSubconjuntoDosFechasIgualesCategoria() {
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fecha2,fecha2,CategoriaNoticia.CULTURA));
	}
	
	@Test
	@Tag("BlackBox")
	void testgetSubconjuntoDosFechasDesordenadasCategoria() {
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		LocalDate fecha3 = LocalDate.of(2014, 9, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fecha3,fecha2,CategoriaNoticia.CULTURA));
	}
	
	
	
}
