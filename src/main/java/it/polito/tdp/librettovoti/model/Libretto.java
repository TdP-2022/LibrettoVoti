package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti ;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>() ;
	}
	
	public boolean add(Voto v) {
		if(!isDuplicato(v) && !isConflitto(v)) {
			this.voti.add(v);
			return true ;
		} else {
			return false ;
		}
	}
	
	public Libretto filtraPunti(int punti) {
		Libretto result = new Libretto() ;
		for(Voto v: this.voti) {
			if(v.getPunti()==punti) {
				result.add(v);
			}
		}
		return result ;
	}
	
	/**
	 * Restituisce il punteggio ottenuto all'esame di cui 
	 * specifico il nome
	 * @param nome Nome dell'esame
	 * @return punteggio numerico, oppure {@code null} se l'esame non esiste
	 */
	public Integer puntiEsame(String nome) {
		for(Voto v: this.voti) {
			if( v.getNome().equals(nome) ) {
				return v.getPunti() ;
			}
		}
//		return -1;
		return null ;
//		throw new IllegalArgumentException("Corso non trovato") ;
	}
	
	
	public boolean isDuplicato(Voto v) {
		for(Voto v1: this.voti) {
			if(v1.equals(v))
				return true ;
		}
		return false ;
	}
	
	
	public boolean isConflitto(Voto v) {
		Integer punti = this.puntiEsame(v.getNome()) ;
		if (punti != null && punti != v.getPunti())
			return true;
		else
			return false;
	}
	
	public List<Voto> getVoti() {
		return this.voti ;
	}
	
	
	public Libretto votiMigliorati() {
		Libretto nuovo = new Libretto() ;
		for(Voto v: this.voti) {
			int punti = v.getPunti() ;
			if(punti>=24)
				punti +=2 ;
			else 
				punti++ ;
			if (punti>30)
				punti=30 ;

			// NOOOO va a modificare l'oggetto nel libretto originale
			//			v.setPunti(punti);
			//			nuovo.add(v) ;
			
			nuovo.add(new Voto(v.getNome(), punti)) ;
		}
		return nuovo ;
	}
	
	
	// FUNZIONERÀ COSÌ??? Proviamo... e capiamo perché
	public void cancellaVotiMinori(int punti) {
		for(Voto v: this.voti) {
			if(v.getPunti()<punti)
				this.voti.remove(v) ;
		}
	}
	
	public String toString() {
		return this.voti.toString() ;
	}
}
