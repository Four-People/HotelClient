package ui.view.user;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.view.Main;

public class ManagerLoginController implements Initializable {
	@FXML
	private Label loginLabel;

	@FXML
	private Label usernameLabel;

	@FXML
	private Label passwordLabel;

	@FXML
	private TextField usernameTextField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button loginButton;

	@FXML
	private Button registButton;

	@FXML
	public void gotoManagerOverview() {
		// TODO ��¼��֤
		main.gotoManagerOverview();
	}



	// Reference to the main application.
	private Main main;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public ManagerLoginController() {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

	}

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
