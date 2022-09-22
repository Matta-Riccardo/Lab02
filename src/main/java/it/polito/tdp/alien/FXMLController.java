/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dizionario model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblStatus"
    private Label lblStatus; // Value injected by FXMLLoader

    @FXML // fx:id="txtInsertText"
    private TextField txtInsertText; // Value injected by FXMLLoader

    @FXML // fx:id="txtTextArea"
    private TextArea txtTextArea; // Value injected by FXMLLoader

    @FXML
    void handleClearText(ActionEvent event) {
    	txtTextArea.clear();
    	txtInsertText.clear();
    	lblStatus.setText("");
    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	
    	String text = txtInsertText.getText().toLowerCase().trim();
    	
	    String parole [] = text.split(" ");
	   	txtTextArea.clear();
	   	lblStatus.setText("");
	    
	   	if (parole.length == 2) {
	    		
	   		if(parole[0].matches("[a-z]*") && parole[1].matches("[a-z]*")) {
	    		String elenco = "";
	    		elenco = model.aggiungiNuovaParola(parole[0], parole[1]);		    		
		    	
	    		if(elenco.equals("Traduzione gia presente")){
		    		txtTextArea.setText(elenco);
		   			lblStatus.setText("Traduzione gia inserita");
		   		}else{
		   			txtTextArea.setText(elenco);
		   			lblStatus.setText("Parola inserita correttamente");
	    		}
	    	}else {
	    		lblStatus.setText("devi inserire solo carattere alfabetici validi");
	   		}
	    		
	   	}else if(parole.length == 1) {
	    	if(parole[0].matches("[a-z]*")){
		   		String result = model.cercaTraduzioneParolaAliena(parole[0]);
		   		txtTextArea.setText(result);
		   		
		   		if(result.equals("Parola aliena non trovata nel dizionario")) {
	    			lblStatus.setText("Traduzione non trovata");
	    		}else { 
	    			lblStatus.setText("Traduzione trovata");
		    	}
	    	}else if(parole[0].matches("[a-z]*\\?{1}[a-z]*")){
	    		String result = model.cercaTraduzioneConWildCard(parole[0]);
	    		txtTextArea.setText(result);
	    		
	    		if(result.equals("Parola aliena non trovata nel dizionario")) {
	    			lblStatus.setText("Traduzione non trovata");
	    		}else { 
	    			lblStatus.setText("Traduzione trovata");
		    	}
	    	}else {
	    		lblStatus.setText("devi inserire solo carattere alfabetici validi");
	    	}
	    }else {
	   		lblStatus.setText("Errore! Puoi inserire al massimo due parole separate da spazio.");
	   	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblStatus != null : "fx:id=\"lblStatus\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInsertText != null : "fx:id=\"txtInsertText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTextArea != null : "fx:id=\"txtTextArea\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Dizionario model) {
		this.model = model;
		
	}

}

