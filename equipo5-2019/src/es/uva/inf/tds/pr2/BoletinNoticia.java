package es.uva.inf.tds.pr2;

import java.util.ArrayList;

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
	 * Consulta la lista de noticias pertenecientes al boletin
	 * @return lista de noticias
	 */
	public ArrayList<Noticia> getListaNoticias() {
		// TODO Auto-generated method stub
		return null;
	}

}
