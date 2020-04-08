package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserisci;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;
    
    @FXML
    void doAnagrammi(ActionEvent event) {
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	
    	String anagramma= txtInserisci.getText(); 	
    	this.model.anagrammi(anagramma);
    	List<Parola> parole= this.model.getSoluzione();
    	
    	for(Parola p: parole) {
    		if(p.getCorretta()==true) {
    			txtAnagrammiCorretti.appendText(p.toString()+"\n");
    		}else {
    			txtAnagrammiErrati.appendText(p.toString()+"\n");
    		}
    	}
    	
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInserisci.clear();
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();

    }


    @FXML
    void initialize() {
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
}
