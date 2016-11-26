package ui.view.hotel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Main;

public class HotelOverviewController implements Initializable {
	private Main main;
	
	@FXML
	private void initialize() {

	}
	
	//����Ƶ���Ϣ
	@FXML
	private void gotoBasicInfo(){
		main.gotoHotelBasicInfo();
	}
	
	//���ÿͷ�����
	@FXML
	private void gotoRoomManage(){
		main.gotoHotelRoomManage();
	}
	
	//�������
	@FXML
	private void gotoOrderBrowse(){
		main.gotoHotelBrowseOrder();
	}
	//����ִ��
	@FXML
	private void gotoOrderExecute(){
		main.gotoHotelExecuteOrder();
	}
	
	//�Ƶ귿����Ϣ����
	@FXML
	private void gotoCheckIn(){
		main.gotoHotelCheckIn();
	}
	
	//�Ƶ����۲��Թ���
	@FXML
	private void gotoStrategyManage(){
		main.gotoHotelStrategyManage();
	}
	
	public HotelOverviewController() {

	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO �Զ����ɵķ������

	}
	
	public void setMain(Main main) {
		this.main = main;
	}

}
