package es.uva.inf.tds.pr2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * Clase de test de caja negra que prueba la clase BoletinNoticia con aislamiento
 * @author silmont
 * @author marrobl
 *
 */
public class BoletinNoticiaIsolationBlackBoxTest {
	
	private ArrayList<Noticia> listaNoticias;
	private BoletinNoticia boletin;
	

	
	@Mock
	private Noticia noticia1Mock, noticia2Mock, noticia3Mock, noticia4Mock;
	
	@BeforeEach
	void setUp() {
		noticia1Mock = mock(Noticia.class);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		when(noticia1Mock.getCategoria()).thenReturn(CategoriaNoticia.INTERNACIONAL);
		when(noticia1Mock.getTitular()).thenReturn("Titular 1");
		when(noticia1Mock.getFecha()).thenReturn(fecha);
		when(noticia1Mock.getFuente()).thenReturn("Fuente de la noticia");
		when(noticia1Mock.getURL()).thenReturn("URL de la noticia");
		
		noticia2Mock = mock(Noticia.class);
		when(noticia2Mock.getCategoria()).thenReturn(CategoriaNoticia.NACIONAL);
		when(noticia2Mock.getTitular()).thenReturn("Titular 2");
		when(noticia2Mock.getFecha()).thenReturn(fecha);
		when(noticia2Mock.getFuente()).thenReturn("Fuente de la noticia");
		when(noticia2Mock.getURL()).thenReturn("URL de la noticia");
	
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);

		noticia3Mock = mock(Noticia.class);
		when(noticia3Mock.getCategoria()).thenReturn(CategoriaNoticia.DEPORTE);
		when(noticia3Mock.getTitular()).thenReturn("Titular 1");
		when(noticia3Mock.getFecha()).thenReturn(fecha2);
		when(noticia3Mock.getFuente()).thenReturn("Fuente de la noticia");
		when(noticia3Mock.getURL()).thenReturn("URL de la noticia");
		
		LocalDate fecha3 = LocalDate.of(2011, 11, 11);

		noticia4Mock = mock(Noticia.class);
		when(noticia4Mock.getCategoria()).thenReturn(CategoriaNoticia.CULTURA);
		when(noticia4Mock.getTitular()).thenReturn("Titular 2");
		when(noticia4Mock.getFecha()).thenReturn(fecha3);
		when(noticia4Mock.getFuente()).thenReturn("Fuente de la noticia");
		when(noticia4Mock.getURL()).thenReturn("URL de la noticia");
		
		
		listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticia1Mock);
		listaNoticias.add(noticia2Mock);
		listaNoticias.add(noticia3Mock);
		listaNoticias.add(noticia4Mock);

	}
	
	@AfterEach
	void tearDown() {
		noticia1Mock = null;
		noticia2Mock = null;	
		noticia3Mock = null;
		noticia4Mock = null;
		boletin = null;

	}

	@Test 
	@Tag("BlackBox")
	@Tag("Isolation")
	void testNoContieneNoticia() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaPrueba = LocalDate.of(2012, 12, 12);
		Noticia noticiaPrueba = mock(Noticia.class);
		when(noticia1Mock.getCategoria()).thenReturn(CategoriaNoticia.CULTURA);
		when(noticia1Mock.getTitular()).thenReturn("titular");
		when(noticia1Mock.getFecha()).thenReturn(fechaPrueba);
		when(noticia1Mock.getFuente()).thenReturn("fuente");
		when(noticia1Mock.getURL()).thenReturn("url");
		assertFalse(boletin.contieneNoticia(noticiaPrueba));
	
	}
	
	@Test 
	@Tag("BlackBox")
	@Tag("Isolation")
	void testAgregarNoticiaRepetida() {
		boletin = new BoletinNoticia(listaNoticias);
		assertThrows(IllegalArgumentException.class, () ->boletin.addNoticia(noticia1Mock));
	}
	
	@Test
	@Tag("BlackBox")
	@Tag("Isolation")
	void testNogetNoticiasSimilares() {
		boletin = new BoletinNoticia(listaNoticias);
		
		LocalDate fechaDistinta = LocalDate.of(2018, 11, 11);
		
		Noticia noticiaNoSimilarMock = mock(Noticia.class);
		when(noticia1Mock.getCategoria()).thenReturn(CategoriaNoticia.SOCIEDAD);
		when(noticia1Mock.getTitular()).thenReturn("Titular distinto");
		when(noticia1Mock.getFecha()).thenReturn(fechaDistinta);
		when(noticia1Mock.getFuente()).thenReturn("Fuente de la noticia");
		when(noticia1Mock.getURL()).thenReturn("URL de la noticia");
		when(noticia1Mock.similar(noticiaNoSimilarMock)).thenReturn(false);
		when(noticia4Mock.similar(noticiaNoSimilarMock)).thenReturn(false);
		when(noticia2Mock.similar(noticiaNoSimilarMock)).thenReturn(false);
		when(noticia3Mock.similar(noticiaNoSimilarMock)).thenReturn(false);
		
		Noticia[] noticiasSimilares = {};
		assertArrayEquals(noticiasSimilares, boletin.getNoticiasSimilares(noticiaNoSimilarMock).toArray());
		
	}
	
	@Test
	@Tag("BlackBox")
	@Tag("Isolation")
	void testgetSubconjuntoDosFechasDesordenadas() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaPost = LocalDate.of(2018, 11, 11);
		LocalDate fechaAnt = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaPost,fechaAnt));
	}
	
	@Test
	@Tag("BlackBox")
	@Tag("Isolation")
	void testgetSubconjuntoDosFechasIguales() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaPost = LocalDate.of(2018, 11, 11);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaPost,fechaPost));
	}
	
	@Test
	@Tag("BlackBox")
	@Tag("Isolation")
	void testgetSubconjuntoDosFechasSegundaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaFallo = null;
		LocalDate fechaPost = LocalDate.of(2018, 11, 11);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaPost,fechaFallo));
	}
	
	@Test
	@Tag("BlackBox")
	@Tag("Isolation")
	void testgetSubconjuntoDosFechasNullCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaFallo = null;
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fecha2,fechaFallo,CategoriaNoticia.NACIONAL));
	}
	
	@Test
	@Tag("BlackBox")
	@Tag("Isolation")
	void testgetSubconjuntoDosFechasCategoriaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		LocalDate fecha3 = LocalDate.of(2014, 9, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fecha2,fecha3,null));
	}
	
	@Test
	@Tag("BlackBox")
	@Tag("Isolation")
	void testgetSubconjuntoDosFechasIgualesCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fecha2,fecha2,CategoriaNoticia.CULTURA));
	}
	
	@Test
	@Tag("BlackBox")
	@Tag("Isolation")
	void testgetSubconjuntoDosFechasDesordenadasCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		LocalDate fecha3 = LocalDate.of(2014, 9, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fecha3,fecha2,CategoriaNoticia.CULTURA));
	}
	
	@Test
	@Tag("BlackBox")
	@Tag("Isolation")
	void testTDDgetPorcentajeSimilitud() {
		boletin = new BoletinNoticia(listaNoticias);
		when(noticia1Mock.similar(noticia1Mock)).thenReturn(true);
		when(noticia4Mock.similar(noticia4Mock)).thenReturn(true);
		when(noticia2Mock.similar(noticia2Mock)).thenReturn(true);
		when(noticia3Mock.similar(noticia3Mock)).thenReturn(true);
		assertEquals(100, boletin.getPorcentajeSimilitud(boletin));
	}
	
}