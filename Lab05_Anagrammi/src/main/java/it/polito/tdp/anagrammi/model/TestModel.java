package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model mod= new Model();
		
		List<Parola> an= mod.anagrammi("ciao");
		System.out.println(an);
	}

}
