package ui.view.client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Main;

public class ClientSearchHotelController implements Initializable{
	private Main main;
	@FXML
	private void initialize(){
		
	}
	@FXML
	private void back(){
		main.gotoClientOverview();
	}
	
	//�ͻ��鿴�Ƶ���ϸ��Ϣ
	@FXML
	private void gotoHotelDetailInfo(){
		main.gotoHotelDetailInfo();
	}
	
	//�ͻ����ɶ���
	@FXML 
	private void gotoGenerateOrder(){
		main.gotoGenerateOrder();
	}
	
	public ClientSearchHotelController() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void setMain(Main main){
		this.main = main;
	}
}
