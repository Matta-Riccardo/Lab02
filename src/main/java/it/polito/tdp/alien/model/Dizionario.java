package it.polito.tdp.alien.model;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Dizionario {
	LinkedList <String> elencoDizionario;
	LinkedList <String> elencoTraduzioni;
	LinkedHashMap <String, Parola> mappaDizionario;
	
	public Dizionario() {
		mappaDizionario = new LinkedHashMap <String, Parola> (); 
		elencoDizionario = new LinkedList <String> ();
		elencoTraduzioni = new LinkedList <String> ();
	}
	
	public String aggiungiNuovaParola(String parolaAliena, String traduzione) {
	
		if(!mappaDizionario.containsKey(parolaAliena) && !elencoTraduzioni.contains(traduzione)) {

			mappaDizionario.put(parolaAliena, new Parola(parolaAliena, traduzione)); 
			
			String aggiungi = parolaAliena + " " + traduzione;
			elencoDizionario.add(aggiungi);
			elencoTraduzioni.add(traduzione);
		}else {
			if(!elencoTraduzioni.contains(traduzione)) {
				String aggiungi = parolaAliena + " " + traduzione;
				mappaDizionario.get(parolaAliena).addTraduzione(traduzione);
				elencoDizionario.add(aggiungi);
			}else {
				return "Traduzione gia presente";
			}
		}
		
		String result = "";
		for(String s : elencoDizionario) {
			if(result != "") {
				result += "\n";
			}
			result += s;
		}
		
		return result;
	}
	
	public String cercaTraduzioneParolaAliena (String parolaAliena) {
		String trovata = "";
		if(!mappaDizionario.containsKey(parolaAliena)) {
			trovata = "Parola aliena non trovata nel dizionario";
			return trovata;
		}else {
			trovata = mappaDizionario.get(parolaAliena).getElencoTraduzioni(); 
			return trovata;
		}
	}
	
	public String cercaTraduzioneConWildCard(String parolaAliena) {
		
		String trovata = "";
		boolean ok = false;
		parolaAliena = parolaAliena.replaceAll("\\?", ".");
		
		
		for(Parola p : mappaDizionario.values()) {
			if(p.getParolaAliena().matches(parolaAliena)) {
				ok = true;
				trovata += mappaDizionario.get(p.getParolaAliena()).getElencoTraduzioni()+"\n";
			}
		}
			
		if(!ok) {
			trovata = "Parola aliena non trovata nel dizionario";
		}
		return trovata;
	}
	
}
