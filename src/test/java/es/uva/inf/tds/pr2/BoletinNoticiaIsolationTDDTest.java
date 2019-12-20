package es.uva.inf.tds.pr2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Clase de test TDD que prueba la clase BoletinNoticia en Aislamiento utilizando mock objects
 * @author silmont
 * @author marrobl
 *
 */

public class BoletinNoticiaIsolationTDDTest {
	private ArrayList<Noticia> listaNoticias;
	private BoletinNoticia boletin;
	private BoletinNoticia boletinVacio;

	
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
		boletinVacio = null;
	}
	
	@Test
	@Tag("Isolation")
	void testTDDConstructorBoletinNoticia() {	
		
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
		
		
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(noticia1Mock);
		listaNoticias.add(noticia2Mock);
		BoletinNoticia boletin = new BoletinNoticia(listaNoticias);
		Noticia[] arrayNoticias = new Noticia[listaNoticias.size()];
		arrayNoticias = listaNoticias.toArray(arrayNoticias);
		assertArrayEquals(arrayNoticias, boletin.getListaNoticias().toArray());
		assertNotNull(boletin.getListaNoticias());
		
	}
	
	@Test
	@Tag("Isolation")
	void testTDDConstructorNull() {
		assertThrows(IllegalArgumentException.class, () ->boletin = new BoletinNoticia(null));
	}
	
	@Test
	@Tag("Isolation")
	void testTDDConstructorVacioBoletinNoticia() {
		BoletinNoticia boletin = new BoletinNoticia();
		assertEquals(0, boletin.getListaNoticias().size());
	}
	
	@Test 
	@Tag("Isolation")
	void testTDDContieneNoticia() {
		boletin = new BoletinNoticia(listaNoticias);
		assertTrue(boletin.contieneNoticia(noticia1Mock));
	}
	
	@Test
	@Tag("Isolation")
	void testTDDContieneNoticiaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		assertThrows(IllegalArgumentException.class, () ->boletin.contieneNoticia(null));
	}
	
	@Test 
	@Tag("Isolation")
	void testTDDAgregarNoticia() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia noticia = mock(Noticia.class);
		when(noticia1Mock.getCategoria()).thenReturn(CategoriaNoticia.NACIONAL);
		when(noticia1Mock.getTitular()).thenReturn("Titular");
		when(noticia1Mock.getFecha()).thenReturn(fecha);
		when(noticia1Mock.getFuente()).thenReturn("Fuente de la noticia");
		when(noticia1Mock.getURL()).thenReturn("URL de la noticia");
		boletin.addNoticia(noticia);
		assertTrue(boletin.contieneNoticia(noticia));
	}
	
	@Test
	@Tag("Isolation")
	void testTDDAgregarNoticiaNull() {
		boletinVacio = new BoletinNoticia();
		assertThrows(IllegalArgumentException.class, () ->boletinVacio.addNoticia(null));
	}
	
	@Test 
	@Tag("Isolation")
	void testTDDgetNumNoticias() {
		boletinVacio = new BoletinNoticia();
		assertEquals(0, boletinVacio.getNumNoticias());
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetOrdenadasFecha() {
		boletin = new BoletinNoticia(listaNoticias);
		Noticia[] arrayNoticiasOrdenada = {noticia4Mock, noticia1Mock, noticia2Mock, noticia3Mock};
		Noticia[] arrayComprobar = new Noticia[boletin.getNoticiasOrdenadas().size()];
		arrayComprobar = boletin.getNoticiasOrdenadas().toArray(arrayComprobar);
		assertArrayEquals(arrayComprobar,arrayNoticiasOrdenada);
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetOrdenadasCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		Noticia[] arrayNoticiasOrdenada = {noticia2Mock, noticia1Mock, noticia3Mock, noticia4Mock};
		Noticia[] arrayComprobar = new Noticia[boletin.getNoticiasOrdenadasCategoria().size()];
		arrayComprobar = boletin.getNoticiasOrdenadasCategoria().toArray(arrayComprobar);
		assertArrayEquals(arrayComprobar,arrayNoticiasOrdenada);
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetFechaNoticiasRecientes() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaAcomparar = LocalDate.of(2014, 05, 05);
		assertEquals(fechaAcomparar, boletin.getFechaNoticiasRecientes());
		
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetFechaNoticiasRecientesExcepcion() {
		boletinVacio = new BoletinNoticia();
		assertThrows(IllegalStateException.class, () ->boletinVacio.getFechaNoticiasRecientes());
		
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetFechaNoticiasAntiguas() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaAcomparar = LocalDate.of(2011, 11, 11);
		assertEquals(fechaAcomparar, boletin.getFechaNoticiasAntiguas());
		
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetFechaNoticiasAntiguasExcepcion() {
		boletinVacio = new BoletinNoticia();
		assertThrows(IllegalStateException.class, () ->boletinVacio.getFechaNoticiasAntiguas());
		
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetNoticiasSimilares() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha3 = LocalDate.of(2011, 11, 11);
		
		Noticia noticiaSimilar = mock(Noticia.class);
		when(noticiaSimilar.getCategoria()).thenReturn(CategoriaNoticia.INTERNACIONAL);
		when(noticiaSimilar.getTitular()).thenReturn("Titular 1");
		when(noticiaSimilar.getFecha()).thenReturn(fecha3);
		when(noticiaSimilar.getFuente()).thenReturn("Fuente de la noticia");
		when(noticiaSimilar.getURL()).thenReturn("URL de la noticia");
		when(noticia1Mock.similar(noticiaSimilar)).thenReturn(true);
		when(noticia4Mock.similar(noticiaSimilar)).thenReturn(true);
		when(noticia2Mock.similar(noticiaSimilar)).thenReturn(false);
		when(noticia3Mock.similar(noticiaSimilar)).thenReturn(false);
		
		Noticia[] esperado = {noticia1Mock, noticia4Mock};
		assertArrayEquals(esperado, boletin.getNoticiasSimilares(noticiaSimilar).toArray());
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetNoticiasSimilaresNull() {
		boletin = new BoletinNoticia(listaNoticias);
		assertThrows(IllegalArgumentException.class, () ->boletin.getNoticiasSimilares(null));
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoUnaFecha() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia[] esperado = {noticia1Mock, noticia2Mock};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoUnaFechaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaFallo = null;
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaFallo));
	}

	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoDosFechas() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		Noticia[] esperado = {noticia1Mock, noticia2Mock, noticia3Mock};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha,fecha2).getListaNoticias().toArray());
	}

	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoDosFechaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(null, fecha2));
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		Noticia[] esperado = {noticia1Mock};
		assertArrayEquals(esperado, boletin.getSubconjunto(CategoriaNoticia.INTERNACIONAL).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoCategoriaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		CategoriaNoticia categoriaFallo = null;
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(categoriaFallo));
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoUnaFechaCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		Noticia[] esperado = {noticia1Mock};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha,CategoriaNoticia.INTERNACIONAL).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoUnaFechaNullCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaFallo = null;
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaFallo,CategoriaNoticia.NACIONAL));
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoDosFechasCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		Noticia[] esperado = {noticia2Mock};
		
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha,fecha2,CategoriaNoticia.NACIONAL).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetSubconjuntoDosFechasNullCategoria() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaFallo = null;
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaFallo,fecha2,CategoriaNoticia.NACIONAL));
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetPorcentajeSimilitud() {
		boletin = new BoletinNoticia(listaNoticias);
		boletinVacio = new BoletinNoticia();
		assertEquals(0, boletinVacio.getPorcentajeSimilitud(boletin));
	}
	
	@Test
	@Tag("Isolation")
	void testTDDgetPorcentajeSimilitudNull() {
		boletin = new BoletinNoticia(listaNoticias);
		assertThrows(IllegalArgumentException.class, () ->boletin.getPorcentajeSimilitud(null));
	}
	
	
	
}
