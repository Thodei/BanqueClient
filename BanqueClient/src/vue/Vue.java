package vue;

import java.net.URL;

import dao.Requete;
import model.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vue {	
	public static Stage parentWindow;
	public static String NumCompte;
	
	public Vue(String VueName,Stage arg0,String NumCompte) throws Exception 
	{
		if ( arg0 != null )
			parentWindow = arg0;	
		this.NumCompte = NumCompte;
		parentWindow.setTitle(VueName+" - BanqueClient");		
		final URL fxml = getClass().getResource("/vue/"+VueName+".fxml");
		final FXMLLoader fxmlLoader = new FXMLLoader(fxml);
		final VBox nodeParent = (VBox) fxmlLoader.load();
		Scene scene = new Scene(nodeParent);
		setStyleSheets(scene,VueName);
		Main.parentWindow.setScene(scene);
		Main.parentWindow.show();
	}
	
	private void setStyleSheets(Scene scene, String vue)
	{
		scene.getStylesheets().add("/vue/form.css");
		
		if (vue.equals("Compte")) 
		{
			scene.getStylesheets().add("/vue/listview.css");
		}
	}
}
