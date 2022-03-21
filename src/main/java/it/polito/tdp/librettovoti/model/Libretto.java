package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettovoti.db.LibrettoDAO;

public class Libretto {
	
	public Libretto() {
	}
	
	public boolean add(Voto v) {
		LibrettoDAO dao = new LibrettoDAO() ;
		boolean result = dao.creaVoto(v);
		return result ;
	}
	
	
	public List<Voto> getVoti() {
		LibrettoDAO dao = new LibrettoDAO() ;
		return dao.readAllVoto();
	}
	
	
	
//	public String toString() {
//		return this.voti.toString() ;
//	}
}
