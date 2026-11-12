package ifsc.tds.henry.leticia.luciane.principal;

import com.ifsc.tds.henry.leticia.luciane.controller.ContatoListaController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ifsc/tds/henry/leticia/luciane/view/ContatoLista.fxml"));
			Parent contatoListaXML = loader.load();

			
			ContatoListaController contatoListaController = loader.getController();
			Scene contatoListaLayout = new Scene(contatoListaXML);

			primaryStage.setScene(contatoListaLayout);
			primaryStage.setTitle("Gerenciamento de Contatos");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);

			
			primaryStage.setOnCloseRequest(e -> {
				if (contatoListaController.onCloseQuery()) {
					System.exit(0);
				} else {
					e.consume();
				}
			});

			primaryStage.show();

			
			Rectangle2D posicaoJanela = Screen.getPrimary().getVisualBounds();
			primaryStage.setX((posicaoJanela.getWidth() - primaryStage.getWidth()) / 2);
			primaryStage.setY((posicaoJanela.getHeight() - primaryStage.getHeight()) / 2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}