package ui.view.market;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Main;

public class MarketOverviewController implements Initializable {
	private Main main;

	/*
	 * ��ת�����ó�ֵ����
	 */
	@FXML
	public void gotoCreditCharge(){
		main.gotoMarketCreditCharge();
	}
	
	/*
	 * ��ת����վ�������Թ�����
	 */
	@FXML
	public void gotoStrategy(){
		main.gotoWebStrategyManage();
	}
	/*
	 * ��ת�������쳣��������
	 */
	@FXML
	public void gotoAbnormalOrder(){
		main.gotoMarketAbnormalOrder();
	}
	public MarketOverviewController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setMain(Main main) {
		this.main = main;
	}
}
