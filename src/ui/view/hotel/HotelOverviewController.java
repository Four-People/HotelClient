package ui.view.hotel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Main;

public class HotelOverviewController implements Initializable {
	private Main main;

	/*
	 * ��ת���Ƶ������Ϣ������
	 */
	@FXML
	public void gotoHotelBasicInfo() {
		main.gotoHotelBasicInfo();
	}

	/*
	 * ��ת���Ƶ������������
	 */
	@FXML
	public void gotoHotelBrowseOrder() {
		main.gotoHotelBrowseOrder();
	}

	/*
	 * ��ת���Ƶ�ͻ���ס����
	 */
	@FXML
	public void gotoHotelCheckIn() {
		main.gotoHotelCheckIn();
	}

	/*
	 * ��ת���Ƶ�ִ�ж�������
	 */
	@FXML
	public void gotoHotelExecuteOrder() {
		main.gotoHotelExecuteOrder();
	}

	/*
	 * ��ת���Ƶ���÷��������
	 */
	@FXML
	public void gotoHotelRoomManage() {
		main.gotoHotelRoomManage();
	}

	/*
	 * ��ת���Ƶ�������Թ�����
	 */
	@FXML
	public void gotoHotelStrategyManage() {
		main.gotoHotelStrategyManage();
	}

	public HotelOverviewController() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO �Զ����ɵķ������

	}

	public void setMain(Main main) {
		this.main = main;
	}

}
