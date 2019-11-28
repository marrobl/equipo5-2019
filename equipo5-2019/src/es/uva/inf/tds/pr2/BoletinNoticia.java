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
		return null;
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
		return 0;
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
		return null;
	}

	public ArrayList<Noticia> getNoticiasOrdenadasCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

}
