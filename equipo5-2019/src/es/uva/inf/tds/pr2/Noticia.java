package es.uva.inf.tds.pr2;

import java.time.LocalDate;

/**
 * Clase que representa una noticia
 * 
 * @author silmont
 * @author marrobl
 *
 */
public class Noticia {

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
	 * 
	 */
	public Noticia(String titular, LocalDate fecha, String fuente, String url, CategoriaNoticia categoria) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Consulta el titular de la noticia
	 * @return titular de la noticia
	 */
	public String getTitular() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta la fecha de publicacion de la noticia 
	 * @return fecha de la noticia
	 */
	public LocalDate getFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta la fuente, nombre del medio o agencia de prensa, de la noticia 
	 * @return fuente de la noticia
	 */
	public String getFuente() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta la url en la que se encuentra la noticia
	 * @return url de la noticia
	 */
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta la categoria en la que se encuadra la noticia, que puede encontrarse
	 * en nacional, internacional, sociedad, economia, deporte y cultura
	 * @return categoria de la noticia
	 */
	public CategoriaNoticia getCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

}
