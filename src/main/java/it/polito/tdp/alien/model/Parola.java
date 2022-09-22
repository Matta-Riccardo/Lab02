package it.polito.tdp.alien.model;

import java.util.LinkedHashSet;

public class Parola {

	private String parolaAliena;
	private LinkedHashSet <String> elencoTraduzioni;
	
	public Parola(String parolaAliena, String traduzione) {
		this.parolaAliena = parolaAliena;
		elencoTraduzioni = new LinkedHashSet <String>();
		elencoTraduzioni.add(traduzione);

	}
	
	public String getParolaAliena() {
		return this.parolaAliena;
	}
	
	public void addTraduzione(String traduzione) {
		this.elencoTraduzioni.add(traduzione);
	}
	
	public String getElencoTraduzioni() {
		String res = "";
		for(String s : elencoTraduzioni) {
			if(res != "") {
				res += "\n";
			}
			res += s;
		}
		return res;
	}
	
	
}
