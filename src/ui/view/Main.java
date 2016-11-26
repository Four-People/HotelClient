package ui.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.view.client.ClientBasicInfoController;
import ui.view.client.ClientBrowseHotelController;
import ui.view.client.ClientEnrollVIPController;
import ui.view.client.ClientEvaluateHotelController;
import ui.view.client.ClientOverviewController;
import ui.view.client.ClientSearchHotelController;
import ui.view.hotel.HotelCheckInController;
import ui.view.hotel.HotelDetailInfoController;
import ui.view.hotel.HotelOverviewController;
import ui.view.hotel.HotelRoomManageController;
import ui.view.hotel.HotelStrategyController;
import ui.view.manager.ManagerOverviewController;
import ui.view.market.CreditChargeController;
import ui.view.market.MarketOverviewController;
import ui.view.market.MarketStrategyController;
import ui.view.order.ClientBrowseOrderController;
import ui.view.order.ClientGenerateOrderController;
import ui.view.order.HotelBrowseOrderController;
import ui.view.order.HotelExecuteOrderController;
import ui.view.order.MarketBrowseAbnormalOrderController;
import ui.view.user.ClientLoginController;
import ui.view.user.ClientRegistController;
import ui.view.user.LoginOverviewController;

public class Main extends Application {
	private Stage stage;
	private Scene scene;
	private final double MINIMUM_WINDOW_WIDTH = 400.0;
	private final double MINIMUM_WINDOW_HEIGHT = 250.0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("Hotel");
		stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
		stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
		stage.setResizable(false);
		initUI();
		stage.show();
	}

	// ��ʼ����
	public void initUI() {
		try {
			LoginOverviewController loginOverviewController = (LoginOverviewController) replaceSceneContent(
					"user/LoginOverview.fxml");
			loginOverviewController.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ��ת���ͻ���¼����
	public void gotoClientLogin() {
		try {
			ClientLoginController loginController = (ClientLoginController) replaceSceneContent("user/Login.fxml");
			loginController.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	// ��ת���Ƶ깤����Ա��¼����
	
	// ��ת����վӪ����Ա��¼����
	
	// ��ת����վ������Ա��¼����
	
	// ��ת��ע�����
	public void gotoRegist() {
		try {
			ClientRegistController registController = (ClientRegistController) replaceSceneContent("user/Regist.fxml");
			registController.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ��ת���ͻ�������
	public void gotoClientOverview() {
		try {
			ClientOverviewController controller = (ClientOverviewController) replaceSceneContent(
					"client/ClientOverview.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ��鿴������Ϣ
	public void gotoClientBasicInfo() {
		try {
			ClientBasicInfoController clientBasicInfoController = (ClientBasicInfoController) replaceSceneContent(
					"client/ClientBasicInfo.fxml");
			clientBasicInfoController.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ�����Ƶ�
	public void gotoClientBrowseHotel() {
		try {
			ClientBrowseHotelController controller = (ClientBrowseHotelController) replaceSceneContent(
					"client/ClientBrowseHotel.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ��������
		public void gotoClientBrowseOrder() {
			try {
				ClientBrowseOrderController controller = (ClientBrowseOrderController) replaceSceneContent(
						"order/ClientBrowseOrder.fxml");
				controller.setMain(this);
			} catch (Exception e) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		
	// �ͻ�ע���Ա
	public void gotoClientEnrollVIP() {
		try {
			ClientEnrollVIPController controller = (ClientEnrollVIPController) replaceSceneContent(
					"client/ClientEnrollVIP.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ����۾Ƶ�
	public void gotoClientEvaluateHotel() {
		try {
			ClientEvaluateHotelController controller = (ClientEvaluateHotelController) replaceSceneContent(
					"client/ClientEvaluateHotel.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ������Ƶ�
	public void gotoClientSearchHotel() {
		try {
			ClientSearchHotelController controller = (ClientSearchHotelController) replaceSceneContent(
					"client/ClientSearchHotel.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//�ͻ��鿴�Ƶ���ϸ��Ϣ
	public void gotoHotelDetailInfo() {
		try {
			ClientSearchHotelController controller = (ClientSearchHotelController) replaceSceneContent(
					"hotel/HotelDetailInfo.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//�ͻ����ɶ���
	public void gotoGenerateOrder() {
		try {
			ClientGenerateOrderController controller = (ClientGenerateOrderController) replaceSceneContent(
					"order/ClientGenerateOrder.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//��ת���Ƶ�������
	public void gotoHotelOverview() {
		try {
			HotelOverviewController HotelOverviewController = (HotelOverviewController) replaceSceneContent(
					"hotel/HotelOverview.fxml");
			HotelOverviewController.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	// �Ƶ깤����Ա����Ƶ���Ϣ
	public void gotoHotelBasicInfo() {
		try {
			HotelDetailInfoController controller = (HotelDetailInfoController) replaceSceneContent(
					"hotel/HotelBasicInfo.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	// �Ƶ���÷������
	public void gotoHotelRoomManage() {
		try {
			HotelRoomManageController controller = (HotelRoomManageController) replaceSceneContent(
					"hotel/HotelRoomManage.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//�Ƶ궩�����
	public void gotoHotelBrowseOrder() {
		try {
			HotelBrowseOrderController controller = (HotelBrowseOrderController) replaceSceneContent(
					"order/HotelBrowseOrder.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	//�Ƶ궩��ִ��
	public void gotoHotelExecuteOrder() {
		try {
			HotelExecuteOrderController controller = (HotelExecuteOrderController) replaceSceneContent(
					"order/HotelExecuteOrder.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	
	//�Ƶ귿����Ϣ����
	public void gotoHotelCheckIn() {
		try {
			HotelCheckInController controller = (HotelCheckInController) replaceSceneContent(
					"hotel/HotelCheckIn.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	//�Ƶ����۲��Թ���
	public void gotoHotelStrategyManage() {
		try {
			HotelStrategyController controller = (HotelStrategyController) replaceSceneContent(
					"hotel/HotelStrategy.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//��ת����վӪ����Ա������
	public void gotoMarketOverview() {
		try {
			MarketOverviewController MarketOverviewController = (MarketOverviewController) replaceSceneContent(
					"market/MarketOverview.fxml");
			MarketOverviewController.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	
	//��վ���۲��Թ���
	public void gotoWebStrategyManage() {
		// TODO Auto-generated method stub
		try {
			MarketStrategyController MarketStrategyController = (MarketStrategyController) replaceSceneContent(
					"market/MarketStrategy.fxml");
			MarketStrategyController.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	//��վӪ����Ա����쳣����
	public void gotoMarketAbnormalOrder() {
		// TODO Auto-generated method stub
		try {
			MarketBrowseAbnormalOrderController controller = (MarketBrowseAbnormalOrderController) replaceSceneContent(
					"order/MarketBrowseAbnormalOrder.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	//���ó�ֵ
	public void gotoMarketCreditCharge() {
		// TODO Auto-generated method stub
		try {
			CreditChargeController controller = (CreditChargeController) replaceSceneContent(
					"order/MarketBrowseAbnormalOrder.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//��ת����վ������Ա������
		public void gotoManagerOverview() {
			try {
				ManagerOverviewController ManagerOverviewController = (ManagerOverviewController) replaceSceneContent(
						"manager/ManagerOverview.fxml");
				ManagerOverviewController.setMain(this);
			} catch (Exception e) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		

	// ������ת��Ҫ����
	private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(fxml));
		AnchorPane pane = (AnchorPane) loader.load();
		this.scene = new Scene(pane);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.centerOnScreen();
		stage.setResizable(false);
		return (Initializable) loader.getController();
	}

	public Stage getPrimaryStage() {
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	

}
