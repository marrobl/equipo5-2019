package es.uva.inf.tds.pr2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

/**
 * Clase que representa un boletin de noticias compuesto por varias noticias
 * @author silmont
 * @author marrobl
 *
 */

public class BoletinNoticia {
	
	/**
	 * Crea un objeto de tipo Boletin Noticia que contiene una lista de Noticias.
	 * @param listaNoticias lista de noticias que pertenecen inicialmente al boletín
	 * 
	 * @pre.condition {@code listaNoticias!=null}
	 * 
	 * @post.condition {@code listaNoticias.equals(this.getListaNoticias())
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */

	public BoletinNoticia(ArrayList<Noticia> listaNoticias) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Crea un objeto de tipo BoletinNoticia que inicialmente no contiene una lista de noticias
	 */
	public BoletinNoticia() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Consulta la lista de noticias pertenecientes al boletin
	 * @return lista de noticias
	 */
	public ArrayList<Noticia> getListaNoticias() {
		// TODO Auto-generated method stub
		return new ArrayList<Noticia>();
	}

	/**
	 * Metodo que agrega una noticia al boletin de noticia existente
	 * 
	 * @param noticia noticia que se quiere agregar
	 * 
	 * @pre.condition {@code noticia != null}
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
 	 */
	public void addNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Devuelve el numero de noticias existentes en el boletin
	 * 
	 * @return numero de noticias 
	 */
	public int getNumNoticias() {
		// TODO Auto-generated method stub
		return 20000;
	}

	/**
	 * Devuelve la lista de Noticias ordenadas por fecha de anterior a posterior
	 * contenidas en el boletin
	 * Si dos noticias tienen la misma fecha, se considera anterior la que primero
	 * se agrego al boletin
	 * 
	 * @return noticias ordenadas por fecha
	 */
	public ArrayList<Noticia> getNoticiasOrdenadas() {
		// TODO Auto-generated method stub
		
		return new ArrayList<Noticia>();
	}
	/**
	 * Devuelve la lista de Noticias contenidas en el boletin ordenadas por categoria
	 * El orden de las categorias es: nacional, internacional, sociedad, economia, deporte y cultura
	 * 
	 * @return noticias ordenadas por categoria
	 */
	public ArrayList<Noticia> getNoticiasOrdenadasCategoria() {
		// TODO Auto-generated method stub
		return new ArrayList<Noticia>();
	}

	/**
	 * Devuelve la fecha de las noticias mas recientes contenidas en el boletin 
	 * 
	 * @pre.condition {@code this.boletin != null}
	 * 
	 * @return fecha noticias mas recientes
	 * 
	 * @throws IllegalStateException cuando no se cumple la precondicion
	 * 
	 */
	public LocalDate getFechaNoticiasRecientes() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve la fecha de las noticias mas recientes 
	 * 
	 * @pre.condition {@code this.boletin != null}
	 * 
	 * @return fecha noticias mas recientes
	 * 
	 * @throws IllegalStateException cuando no se cumple la precondicion
	 */
	public LocalDate getFechaNoticiasAntiguas() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Comprueba si una noticia esta en this.boletin
	 * 
	 * @param noticia noticia que se quiere comprobar
	 * 
	 * @pre.condition {@code noticia != null}
	 * 
	 * @return true si esta en el boletin, false en cualquier otro caso
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public Boolean contieneNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Devuelve una lista de noticias similares a una noticia dada
	 * Dos noticias son similares cuando tienen el mismo titular y categoria, 
	 * o la misma fecha con una diferencia de hasta dos dias
	 * 
	 * @param noticia noticia con la que se quiere comparar
	 * 
	 * @pre.condition {@code noticia != null}
	 * 
	 * @return lista de noticias similares, si no hay ninguna devuelve una lista vacia
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public ArrayList<Noticia> getNoticiasSimilares(Noticia noticia) {
		// TODO Auto-generated method stub
		return new ArrayList<Noticia>();
	}

	/**
	 * Devuelve un boletin de noticias que contiene todas las noticias
	 * de this.boletin publicadas en la fecha que se le pasa como parametro
	 * 
	 * @param fecha fecha de publicacion de las noticias que se quiere seleccionar
	 * 
	 * @pre.condition {@code fecha != null}
	 * 
	 * @return subboletin con el conjunto de noticias publicadas en esa fecha
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public BoletinNoticia getSubconjunto(LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve un boletin de noticias que contiene todas las noticias
	 * de this.boletin publicadas entre las dos fechas pasadas como parametro
	 * 
	 * @param fecha1 fecha inicial del intervalo
	 * @param fecha2 fecha final del intervalo
	 * 
	 * @pre.condition {@code fecha1 != null} 
	 * @pre.condition {@code fecha2 != null}
	 * 
	 * @return subboletin con las noticias entre las dos fechas
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public BoletinNoticia getSubconjunto(LocalDate fecha1, LocalDate fecha2) {
		// TODO Auto-generated method stub
		return null;
	}

}
