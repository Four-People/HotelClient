package ui.view.market;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.view.Main;

public class MarketOverviewController implements Initializable {
	private Main main;
	
	//��վ���۲��Թ���
	@FXML
	private void gotoStrategyManage(){
		main.gotoWebStrategyManage();
	}
	
	//�쳣�������
	@FXML
	private void gotoAbnormalOrder(){
		main.gotoMarketAbnormalOrder();
	}
	
	//���ó�ֵ
	@FXML
	private void gotoCreditCharge(){
		main.gotoMarketCreditCharge();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO �Զ����ɵķ������

	}
	
	public void setMain(Main main) {
		this.main = main;
	}

}
