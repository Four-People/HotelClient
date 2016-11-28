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

	/*
	 * ��ת���ͻ�������Ϣ������
	 */
	@FXML
	private void gotoBasicInfo() {
		main.gotoClientBasicInfo();
	}

	/*
	 * ��ת���ͻ������ʷ�Ƶ괰��
	 */
	@FXML
	private void gotoBrowseHotel() {
		main.gotoClientBrowseHotel();
	}

	/*
	 * ��ת���ͻ�ע���Ա����
	 */
	@FXML
	private void gotoEnrollVIP() {
		main.gotoClientEnrollVIP();
	}

	/*
	 * ��ת���ͻ������ʷ��������
	 */
	@FXML
	private void gotoBrowseOrder() {
		main.gotoClientBrowseOrder();
	}

	/*
	 * ��ת���ͻ������Ƶ괰��
	 */
	@FXML
	private void gotoSearchHotel() {
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
