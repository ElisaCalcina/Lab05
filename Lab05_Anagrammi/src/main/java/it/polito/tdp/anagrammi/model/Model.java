package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private List<Parola> soluzione;
	
	public List<Parola> anagrammi (String parola){
		soluzione= new ArrayList<Parola>();
		List<Character> disponibili = new ArrayList<Character>();
		
		parola.toLowerCase();
		
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}
		cerca(" ", 0, disponibili);
		
		return soluzione;
	}
	
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if(disponibili.size()==0 && isCorrect(parziale)) {
				Parola p = new Parola(parziale, true);
				soluzione.add(p);
		}
		
		for(Character ch: disponibili) {
			String tentativo= parziale+ch;
			
			List<Character> rimanenti= new ArrayList<Character>(disponibili);
			rimanenti.remove(ch);
			
			cerca(tentativo, livello+1, rimanenti);
		}
	}
	
	public boolean isCorrect(String anagramma) {
		AnagrammaDAO dao= new AnagrammaDAO();
		return dao.isCorrect(anagramma);
	}
	
	public List<Parola> getSoluzione(){
		return this.soluzione;
	}
	
}
