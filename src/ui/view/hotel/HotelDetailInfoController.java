package ui.view.hotel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Main;

public class HotelDetailInfoController implements Initializable {
	private Main main;
	public HotelDetailInfoController() {
		// TODO �Զ����ɵĹ��캯�����
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO �Զ����ɵķ������

	}
	
	//�رվƵ���ϸ��Ϣ����
	@FXML
	public void close(){
		main.closeExtraStage();
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
