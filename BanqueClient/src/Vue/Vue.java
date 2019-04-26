package Vue;

import java.net.URL;

import Dao.Requete;
import Model.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vue {	
	public static Stage parentWindow;
	public static String NumCompte;
	
	public Vue(String VueName,Stage arg0,String NumCompte) throws Exception {
		if ( arg0 != null )
			parentWindow = arg0;	
		this.NumCompte = NumCompte;
		parentWindow.setTitle(VueName+" - BanqueClient");		
		
		final URL fxml = getClass().getResource("/Vue/"+VueName+".fxml");
		final FXMLLoader fxmlLoader = new FXMLLoader(fxml);
		final VBox nodeParent = (VBox) fxmlLoader.load();
		
		Scene scene = new Scene(nodeParent);
		Main.parentWindow.setScene(scene);
		
		Main.parentWindow.show();
	}
}
