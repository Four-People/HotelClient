package ui.view.manager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import ui.view.Main;

public class ManagerOverviewController implements Initializable {
	private Main main;
	public ManagerOverviewController() {
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setMain(Main main) {
		this.main = main;
	}
}
