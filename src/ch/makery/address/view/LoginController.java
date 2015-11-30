package ch.makery.address.view;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.controlsfx.dialog.Dialogs;

import ch.makery.address.control.Login;
import ch.makery.address.control.MainApp;
import ch.makery.address.util.DateUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {
	private Login login;
	private static String user = "prueba";
	private static String contraseña = "1234";
	private Window stage;
	@FXML
	private Button enter;
	@FXML
	private TextField username;
	@FXML
	private TextField password;

	@FXML
	private void initialize() {

		password.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ENTER)) {
					try {
						if (verifyCredentials()) {
							new MainApp().start(new Stage());
							// Se obtiene ventana
							stage = username.getScene().getWindow();
							// se cierra
							stage.hide();
						}

					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
	}

	@FXML
	private void handleEnter() throws InvocationTargetException, IOException {
		if (verifyCredentials()) {
			new MainApp().start(new Stage());
			stage = username.getScene().getWindow();
			stage.hide();
		}

	}

	public boolean verifyCredentials() throws InvocationTargetException {
		if (username.getText().equals(user) && password.getText().equals(contraseña)) {
			return true;
		} else {
			Dialogs.create().title("Login y Contraseña Incorrecta").message("prueba y 1234").showError();
			return false;
		}

	}

	public void setLogIn(Login login) {
		this.login = login;
	}

}
