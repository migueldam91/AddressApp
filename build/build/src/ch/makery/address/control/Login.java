package ch.makery.address.control;

import java.io.IOException;

import ch.makery.address.view.LoginController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application{
	
	private AnchorPane rootLayout;
	private Stage primaryStage;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage=primaryStage;
		primaryStage.setTitle("AddressApp");
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/ch/makery/address/view/Login.fxml"));
        rootLayout = (AnchorPane) loader.load();
        rootLayout.setVisible(true);
		
        LoginController loginController= new LoginController();
        loginController.setLogIn(this);
        
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();	
        
        
	}
}
