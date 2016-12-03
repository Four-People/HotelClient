package ui.view.client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import ui.view.Main;

public class ClientSearchHotelController implements Initializable{
	private Main main;
	
	@FXML
	private SplitMenuButton locationButton;
	
	@FXML
	private MenuItem locationMenuItem1;
	
	@FXML
	private MenuItem locationMenuItem2;
	
	@FXML
	private MenuItem locationMenuItem3;
	
	@FXML
	private SplitMenuButton businessAddressButton;
	
	@FXML
	private MenuItem businessAddressMenuItem1;
	
	@FXML
	private MenuItem businessAddressMenuItem2;
	
	@FXML
	private MenuItem businessAddressMenuItem3;
	
	
	
	
	@FXML
	private SplitMenuButton roomtypeButton;
	
	@FXML
	private SplitMenuButton starButton;
	
	@FXML
	private SplitMenuButton lowscoreButton;
	
	@FXML
	private SplitMenuButton highscoreButton;
	@FXML
	private void initialize(){
		
	}
	
	//���Բ���Ϊ��������
	@FXML
	private void locationAction1(){
		locationButton.setText("�Ͼ�");
		//TODO
	}
	@FXML
	private void locationAction2(){
		locationButton.setText("����");
		//TODO
	}
	@FXML
	private void locationAction3(){
		locationButton.setText("�Ϻ�");
		//TODO
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
