package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.time.Month;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto() ;
		lib.add(new Voto("Analisi 1", 30, 
				LocalDate.of(2022,Month.APRIL, 4)));
		lib.add(new Voto("Informatica", 25,
				LocalDate.parse("2022-04-05")));
		lib.add(new Voto("Fisica 1", 18,
				LocalDate.of(2021,Month.MAY, 14)));
		lib.add(new Voto("Algebra lineare", 25,
				LocalDate.parse("2021-07-20")));
		
		System.out.println(lib) ;
		
		System.out.println("Voti pari a 25");
//		Libretto lib25 = lib.filtraPunti(25);
//		System.out.println(lib25) ;

	}

}
