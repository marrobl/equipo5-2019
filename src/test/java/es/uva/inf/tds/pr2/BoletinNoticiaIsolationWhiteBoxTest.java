package es.uva.inf.tds.pr2;

import static org.junit.Assert.assertArrayEquals;
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
 * Clase de test de caja blanca que prueba la clase BoletinNoticia con aislamiento
 * @author silmont
 * @author marrobl
 *
 */
public class BoletinNoticiaIsolationWhiteBoxTest {
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
	@Tag("WhiteBox")
	@Tag("Isolation")
	void testWhiteBoxgetSubconjuntoDosFechasIntervaloGrande() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 11, 12);
		LocalDate fecha2 = LocalDate.of(2014, 06, 05);
		Noticia[] esperado = {noticia1Mock, noticia2Mock, noticia3Mock};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha,fecha2).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("WhiteBox")
	@Tag("Isolation")
	void testWhiteBoxgetSubconjuntoFechaCategoriaNull() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 11, 12);
		CategoriaNoticia categoriaNull = null;
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fecha,categoriaNull));
	}
	
	@Test
	@Tag("WhiteBox")
	@Tag("Isolation")
	void testWhiteBoxgetSubconjuntoFechaCategoriaNullTodo() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fechaNull = null;
		CategoriaNoticia categoriaNull = null;
		assertThrows(IllegalArgumentException.class, () ->boletin.getSubconjunto(fechaNull,categoriaNull));
	}
	
	@Test
	@Tag("WhiteBox")
	@Tag("Isolation")
	void testTDDgetSubconjuntoDosFechasUnaIgual() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 11, 12);
		LocalDate fecha2 = LocalDate.of(2014, 05, 05);
		Noticia[] esperado = {noticia1Mock, noticia2Mock, noticia3Mock};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha,fecha2).getListaNoticias().toArray());
	}
	
	@Test
	@Tag("WhiteBox")
	@Tag("Isolation")
	void testTDDgetSubconjuntoDosFechasDiferentesCondiciones() {
		boletin = new BoletinNoticia(listaNoticias);
		LocalDate fecha = LocalDate.of(2012, 12, 12);
		LocalDate fecha2 = LocalDate.of(2014, 06, 05);
		Noticia[] esperado = {noticia1Mock, noticia2Mock, noticia3Mock};
		assertArrayEquals(esperado, boletin.getSubconjunto(fecha,fecha2).getListaNoticias().toArray());
	}

}
