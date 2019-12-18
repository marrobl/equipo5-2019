package es.uva.inf.tds.pr2;

import java.time.LocalDate;
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
	 * Si alguna de las noticias de la lista inicial esta repetida, solo se introducira una de ellas en
	 * el boletin.
	 * @param listaNoticias lista de noticias que pertenecen inicialmente al boletín
	 * 
	 * @pre.condition {@code listaNoticias!=null}
	 * 
	 * @post.condition {@code listaNoticias.equals(this.getListaNoticias())
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	private ArrayList<Noticia> listaNoticias;
	
	public BoletinNoticia(ArrayList<Noticia> listaNoticias) {
		if(listaNoticias == null) throw new IllegalArgumentException();
		this.listaNoticias = listaNoticias;
	}

	/**
	 * Crea un objeto de tipo BoletinNoticia que inicialmente no contiene una lista de noticias
	 */
	public BoletinNoticia() {
		this.listaNoticias = new ArrayList<>();
	}

	/**
	 * Consulta la lista de noticias pertenecientes al boletin
	 * @return lista de noticias
	 */
	public ArrayList<Noticia> getListaNoticias() {
		return listaNoticias;
	}

	/**
	 * Metodo que agrega una noticia al boletin de noticia existente
	 * 
	 * @param noticia noticia que se quiere agregar
	 * 
	 * @pre.condition {@code noticia != null}
	 * @pre.condition this.boletin.contieneNoticia({@code noticia})==false
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
 	 */
	public void addNoticia(Noticia noticia) {
		if(noticia == null) throw new IllegalArgumentException();
		if(this.contieneNoticia(noticia)) throw new IllegalArgumentException();
		listaNoticias.add(noticia);
	}

	/**
	 * Devuelve el numero de noticias existentes en el boletin
	 * 
	 * @return numero de noticias 
	 */
	public int getNumNoticias() {
		int numNoticias = listaNoticias.size();
		return numNoticias;
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
		ArrayList<Noticia> noticiasOrdenadas = new ArrayList<>();
		noticiasOrdenadas = listaNoticias;
		noticiasOrdenadas.sort((f1, f2) -> f1.getFecha().compareTo(f2.getFecha()));
		return noticiasOrdenadas;
	}
	
	/**
	 * Devuelve la lista de Noticias contenidas en el boletin ordenadas por categoria
	 * El orden de las categorias es: nacional, internacional, sociedad, economia, deporte y cultura
	 * 
	 * @return noticias ordenadas por categoria
	 */
	public ArrayList<Noticia> getNoticiasOrdenadasCategoria() {
		ArrayList<Noticia> noticiasOrdenadas = new ArrayList<>();
		noticiasOrdenadas = listaNoticias;
		noticiasOrdenadas.sort((c1, c2) -> c1.getCategoria().compareTo(c2.getCategoria()));
		return noticiasOrdenadas;
	}

	/**
	 * Devuelve la fecha de las noticias mas recientes contenidas en el boletin 
	 * 
	 * @pre.condition {@code this.listaNoticias.size() != 0}
	 * 
	 * @return fecha noticias mas recientes
	 * 
	 * @throws IllegalStateException cuando no se cumplen las precondiciones
	 * 
	 */
	public LocalDate getFechaNoticiasRecientes() {
		if(this.listaNoticias.size() == 0) throw new IllegalStateException();
		LocalDate fechaReciente;
		ArrayList<Noticia> noticiasOrdenadas = this.getNoticiasOrdenadas();
		fechaReciente = noticiasOrdenadas.get(noticiasOrdenadas.size()-1).getFecha();
		return fechaReciente;
	}

	/**
	 * Devuelve la fecha de las noticias mas recientes 
	 * 
	 * @pre.condition {@code this.listaNoticias.size() == 0}
	 * 
	 * @return fecha noticias mas recientes
	 * 
	 * @throws IllegalStateException cuando no se cumple la precondicion
	 */
	public LocalDate getFechaNoticiasAntiguas() {
		if(this.listaNoticias.size() == 0) throw new IllegalStateException();
		LocalDate fechaAntigua;
		ArrayList<Noticia> noticiasOrdenadas = this.getNoticiasOrdenadas();
		fechaAntigua = noticiasOrdenadas.get(0).getFecha();
		return fechaAntigua;
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
		if(noticia == null) throw new IllegalArgumentException();
		return this.listaNoticias.contains(noticia);
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
		if(noticia == null) throw new IllegalArgumentException();
		ArrayList<Noticia> noticiasSimilares = new ArrayList<>();
		for(Noticia ntc : listaNoticias) {
			if(ntc.similar(noticia)){
				noticiasSimilares.add(ntc);
			} 
		}
		return noticiasSimilares;
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
		if(fecha == null) throw new IllegalArgumentException();
		BoletinNoticia subBoletin = new BoletinNoticia();
		for(Noticia ntc : listaNoticias) {
			if(ntc.getFecha().isEqual(fecha)) subBoletin.addNoticia(ntc);
		}
		return subBoletin;
	}

	/**
	 * Devuelve un boletin de noticias que contiene todas las noticias
	 * de this.boletin publicadas entre las dos fechas pasadas como parametro
	 * 
	 * @param fechaInicial fecha inicial del intervalo
	 * @param fechaFinal fecha final del intervalo
	 * 
	 * @pre.condition {@code fechaInicial != null} 
	 * @pre.condition {@code fechaFinal != null}
	 * @pre.condition {@code fechaInicial} anterior a {@code fechaFinal} 
	 * 
	 * @return subboletin con las noticias entre las dos fechas
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public BoletinNoticia getSubconjunto(LocalDate fechaInicial, LocalDate fechaFinal) {
		if(fechaInicial == null || fechaFinal == null) throw new IllegalArgumentException();
		BoletinNoticia subBoletin = new BoletinNoticia();
		for(Noticia ntc : listaNoticias) {
			if((ntc.getFecha().isAfter(fechaInicial) || ntc.getFecha().isEqual(fechaInicial)) && (ntc.getFecha().isBefore(fechaFinal) || ntc.getFecha().isEqual(fechaFinal)) ) subBoletin.addNoticia(ntc);
		}
		return subBoletin;
	}

	/**
	 * Devuelve un boletin de noticias que contiene todas las noticias de
	 * this.boletin publicadas con la misma categoria que la catgeoria pasada
	 * como parametro
	 * 
	 * @param categoria de la noticia
	 * 
	 * @pre.condition {@code categoria != null}
	 * 
	 * @return subboletin con las noticias de igual categoria
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public BoletinNoticia getSubconjunto(CategoriaNoticia categoria) {
		if(categoria == null) throw new IllegalArgumentException();
		BoletinNoticia subBoletin = new BoletinNoticia();
		for(Noticia ntc : listaNoticias) {
			if(ntc.getCategoria().equals(categoria)) subBoletin.addNoticia(ntc);
		}
		return subBoletin;
	}

	/**
	 * Devuelve un boletin de noticias que contiene todas las noticias de
	 * this.boletin publicadas en la fecha introducida y con la misma
	 * categoria introducida por parametro
	 * 
	 * @param fecha de la publicacion de las noticias
	 * @param categoria categoria de las noticias
	 * 
	 * @pre.condition {@code fecha != null}
	 * @pre.condition {@code categoria != null}
	 * 
	 * @return subboletin que contiene todas las noticias publicadas en esa fecha y
	 * con esa categoria
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public BoletinNoticia getSubconjunto(LocalDate fecha, CategoriaNoticia categoria) {
		if(fecha == null || categoria == null) throw new IllegalArgumentException();
		BoletinNoticia subBoletin = this.getSubconjunto(categoria).getSubconjunto(fecha);
		return subBoletin;
	}

	/**
	 * Devuelve un boletin de noticias que contiene todas las noticias de
	 * this.boletin publicadas en el intervalo que forman las dos fechas pasadas como
	 * parametro y que son de la misma categoria que la introducida como
	 * parametro
	 * 
	 * @param fechaInicial fecha inicial del intervalo de publicacion 
	 * @param fechaFinal fecha final del intervalo
	 * @param categoria categoria a la que pertenece la noticia
	 * 
	 * @pre.condition {@code fechaInicial != null}
	 * @pre.condition {@code fechaFinal != null}
	 * @pre.condition {@code categoria != null}
	 * @pre.condition {@code fechaInicial} anterior a {@code fechaFinal}
	 * 
	 * @return subboletin con noticias comprendidas en el intervalo y de la
	 * categoria correspondiente
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public BoletinNoticia getSubconjunto(LocalDate fechaInicial, LocalDate fechaFinal, CategoriaNoticia categoria) {
		if(fechaInicial == null || fechaFinal == null || categoria == null) throw new IllegalArgumentException();
		BoletinNoticia subBoletin = this.getSubconjunto(fechaInicial, fechaFinal).getSubconjunto(categoria);
		return subBoletin;
	}

	/**
	 * Devuelve el porcentaje de similitud entre las noticias de this.boletin y el boletin 
	 * pasado como parametro
	 * 
	 * @param boletin boletin con el que se quiere comparar this.boletin
	 * 
	 * @pre.condition {@code this.boletin!=null}
	 * 
	 * 
	 * @return porcentaje de similitud (entre 0 y 100)
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen la precondicion
	 */
	public int getPorcentajeSimilitud(BoletinNoticia boletin) {
		if(boletin == null) throw new IllegalArgumentException();
		int contadorSimilares = 0;
		for(Noticia ntc1 : listaNoticias) {
			for(Noticia ntc2 : boletin.getListaNoticias()) {
				if(ntc1.similar(ntc2)) contadorSimilares++;
			}
		}
		return (contadorSimilares/boletin.getNumNoticias())*100;
	}

}
