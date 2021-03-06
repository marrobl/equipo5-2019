package es.uva.inf.tds.pr2;

import java.time.LocalDate;
import java.time.temporal.*;

/**
 * Clase que representa una noticia
 * 
 * @author silmont
 * @author marrobl
 * 
 *
 */
public class Noticia {

	private String titular;
	private LocalDate fecha;
	private String fuente;
	private String url;
	private CategoriaNoticia categoria;
	/**
	 * Crea un objeto de tipo Noticia que tiene un titular, una fecha de publicacion,
	 * una fuente, una url y una categoria
	 * 
	 * @param titular titular de la noticia 
	 * @param fecha fecha de publicacion de la noticia
	 * @param fuente nombre del medio o agencia de prensa 
	 * @param url url donde se encuentra la noticia
	 * @param categoria categoria a la que pertenece la noticia, puede ser
	 * nacional, internacional, sociedad, economia, deporte o cultura
	 * 
	 * @pre.condition {@code titular!=null}
	 * @pre.condition {@code titular} entre una y trece palabras 
	 * @pre.condition {@code fecha!=null}
	 * @pre.condition {@code fuente != null}
	 * @pre.condition {@code url != null}
	 * @pre.condition {@code categoria != null}
	 * 
	 * @post.condition {@code titular.equals(this.getTitular())}
	 * @post.condition {@code fecha.isEqual(this.getFecha())}
	 * @post.condition {@code fuente.equals(this.getFuente())}
	 * @post.condition {@code url.equals(this.url))}
	 * @post.condition {@code categoria.equals(this.getCategoria())}
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 * 
	 */
	public Noticia(String titular, LocalDate fecha, String fuente, String url, CategoriaNoticia categoria) {
		if(titular == null) throw new IllegalArgumentException();
		if(fecha == null) throw new IllegalArgumentException();
		if(fuente == null) throw new IllegalArgumentException();
		if(url == null) throw new IllegalArgumentException();
		if(categoria == null) throw new IllegalArgumentException();
		String[] splitted = titular.split(" ");
		if(titular == "" || splitted.length > 12) throw new IllegalArgumentException(); 
		this.titular = titular;
		this.fecha = fecha;
		this.fuente = fuente;
		this.url = url;
		this.categoria = categoria;
	}

	/**
	 * Consulta el titular de la noticia
	 * @return titular de la noticia
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * Consulta la fecha de publicacion de la noticia 
	 * @return fecha de la noticia
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Consulta la fuente, nombre del medio o agencia de prensa, de la noticia 
	 * @return fuente de la noticia
	 */
	public String getFuente() {
		return fuente;
	}

	/**
	 * Consulta la url en la que se encuentra la noticia
	 * @return url de la noticia
	 */
	public String getURL() {
		return url;
	}

	/**
	 * Consulta la categoria en la que se encuadra la noticia, que puede encontrarse
	 * en nacional, internacional, sociedad, economia, deporte y cultura
	 * @return categoria de la noticia
	 */
	public CategoriaNoticia getCategoria() {
		return categoria;
	}
	
	/**
	 * Compara dos noticias utilizando su fechas de publicacion
	 * determinando si es anterior, igual o posterior
	 * 
	 * @param noticia noticia a comparar con this.noticia
	 * 
	 * @pre.condition {@code noticia != null}
	 * @return -1 si this.noticia es anterior, 0 si son iguales y
	 * 1 si this.noticia es posterior
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen la precondiciones 
	 */
	public int comparaNoticia(Noticia noticia) {
		if(noticia == null) throw new IllegalArgumentException();
		int resultado = 2;
		if(this.fecha.isBefore(noticia.getFecha())) resultado = -1;
		if(this.fecha.isAfter(noticia.getFecha())) resultado = 1;
		if(this.fecha.isEqual(noticia.getFecha())) resultado = 0;			
		return resultado;
	}

	/**
	 * Consulta si una noticia es similar a this.noticia
	 * basandose en si el titular y la categoria coinciden,
	 * o si la fecha de publicacion se diferencian en hasta
	 * dos dias 
	 *
	 * @param noticia a comparar con this.noticia
	 * 
	 * @pre.condition {@code noticia != null}
	 *
	 * @return true si las noticias son similares, false en cualquier otro caso
	 * 
	 * @throws IllegalArgumentException cuando la precondicion no se cumple
	 */
	public boolean similar(Noticia noticia) {
		if(noticia == null) throw new IllegalArgumentException();
		boolean resultado = false;
		if(this.titular.equals(noticia.getTitular()) && this.categoria.equals(noticia.getCategoria())) resultado = true;
		long daysBetween = ChronoUnit.DAYS.between(noticia.getFecha(),this.fecha);
		if(Math.abs(daysBetween)<=2) resultado = true;
		return resultado;
	}

}
