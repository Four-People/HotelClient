package ui.view.client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Main;

public class ClientEvaluateHotelController implements Initializable{
	private Main main;
	@FXML
	private void initialize(){
		
	}
	@FXML
	private void back(){
		main.gotoClientOverview();
	}
	public ClientEvaluateHotelController() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void setMain(Main main){
		this.main = main;
	}
}