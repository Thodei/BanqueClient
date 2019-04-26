package Controller;

import Vue.Vue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailCompteController {

	@FXML private Label Label_Titre;
	
	@FXML 
    public void initialize() {    	
		Label_Titre.setText("Compte Test : " + Vue.NumCompte);
    }  
	
    @FXML 
    public void Btn_Retour_Click() {
    	
    }
}
