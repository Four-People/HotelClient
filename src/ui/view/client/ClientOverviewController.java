package ui.view.client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Main;

public class ClientOverviewController implements Initializable {
	private Main main;

	@FXML
	private void initialize() {

	}
	
	//�鿴�ͻ�������Ϣ
	@FXML
	private void gotoBasicInfo(){
		main.gotoClientBasicInfo();
	}
	
	//���Ԥ�����ľƵ�
	@FXML
	private void gotoBrowseHotel(){
		main.gotoClientBrowseHotel();
	}
	
	//ע���Ա
	@FXML
	private void gotoEnrollVIP(){
		main.gotoClientEnrollVIP();
	}
	
	//�������
	@FXML
	private void gotoBrowseOrder(){
		main.gotoClientBrowseOrder();
	}
	
	//�����Ƶ�
	@FXML
	private void gotoSearchHotel(){
		main.gotoClientSearchHotel();
	}
	
	public ClientOverviewController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setMain(Main main) {
		this.main = main;
	}
}
