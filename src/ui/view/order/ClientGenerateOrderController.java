package ui.view.order;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Main;

public class ClientGenerateOrderController implements Initializable {
	private Main main;

	public ClientGenerateOrderController() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO �Զ����ɵķ������

	}
//	//�ص��ͻ�������
//	@FXML
//	public void gotoClientOverview(){
//		main.gotoClientSearchHotel();
//	}

	public void setMain(Main main) {
		this.main = main;
	}

}