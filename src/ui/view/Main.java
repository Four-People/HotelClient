package ui.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.view.client.ClientBasicInfoController;
import ui.view.client.ClientBrowseHotelController;
import ui.view.client.ClientEnrollVIPController;
import ui.view.client.ClientEvaluateHotelController;
import ui.view.client.ClientOverviewController;
import ui.view.client.ClientSearchHotelController;
import ui.view.market.*;
import ui.view.hotel.*;
import ui.view.manager.ManagerOverviewController;
import ui.view.market.CreditChargeController;
import ui.view.market.MarketStrategyController;
import ui.view.order.*;
import ui.view.user.LoginController;
import ui.view.user.LoginOverviewController;
import ui.view.user.RegistController;

public class Main extends Application {
	private Stage stage;
	private SplitPane rootLayout;
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

	// ��ת����¼����
	public void gotoLogin(String type) {
		try {
			LoginController loginController = (LoginController) replaceSceneContent("user/Login.fxml");
			loginController.setMain(this,type);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ��ת��ע�����
	public void gotoRegist(String type) {
		try {
			RegistController registController = (RegistController) replaceSceneContent("user/Regist.fxml");
			registController.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ��ת���ͻ�������
	public void gotoClientOverview() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientOverview.fxml"));
			rootLayout = (SplitPane) fxmlLoader.load();
			rootLayout.setPrefSize(1000, 600);
			rootLayout.setDividerPositions(0.3f);
			ClientOverviewController controller = (ClientOverviewController) fxmlLoader.getController();
			controller.setMain(this);
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ��鿴������Ϣ
	public void gotoClientBasicInfo() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientBasicInfo.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientBasicInfoController controller = (ClientBasicInfoController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ�����Ƶ�
	public void gotoClientBrowseHotel() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientBrowseHotel.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientBrowseHotelController controller = (ClientBrowseHotelController) fxmlLoader.getController();
			controller.setMain(this);
			stage.centerOnScreen();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ��������
	public void gotoClientBrowseOrder() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("order/ClientBrowseOrder.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientBrowseOrderController controller = (ClientBrowseOrderController) fxmlLoader.getController();
			controller.setMain(this);
			stage.centerOnScreen();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ�ע���Ա
	public void gotoClientEnrollVIP() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientEnrollVIP.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientEnrollVIPController controller = (ClientEnrollVIPController) fxmlLoader.getController();
			controller.setMain(this);
			stage.centerOnScreen();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ����۾Ƶ�
	public void gotoClientEvaluateHotel() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientEvaluateHotel.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientEvaluateHotelController controller = (ClientEvaluateHotelController) fxmlLoader.getController();
			controller.setMain(this);
			stage.centerOnScreen();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ������Ƶ�
	public void gotoClientSearchHotel() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientSearchHotel.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientSearchHotelController controller = (ClientSearchHotelController) fxmlLoader.getController();
			controller.setMain(this);
			stage.centerOnScreen();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ��鿴�Ƶ���ϸ��Ϣ
	public void gotoHotelDetailInfo() {
		try {
			ClientSearchHotelController controller = (ClientSearchHotelController) replaceSceneContent(
					"hotel/HotelDetailInfo.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �ͻ����ɶ���
	public void gotoGenerateOrder() {
		try {
			ClientGenerateOrderController controller = (ClientGenerateOrderController) replaceSceneContent(
					"order/ClientGenerateOrder.fxml");
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ��ת���Ƶ�������
	public void gotoHotelOverview() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelOverview.fxml"));
			rootLayout = (SplitPane) fxmlLoader.load();
			rootLayout.setPrefSize(1000, 600);
			rootLayout.setDividerPositions(0.3f);
			HotelOverviewController controller = (HotelOverviewController) fxmlLoader.getController();
			controller.setMain(this);
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �Ƶ깤����Ա����Ƶ���Ϣ
	public void gotoHotelBasicInfo() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelBasicInfo.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelBasicInfoController controller = (HotelBasicInfoController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �Ƶ���÷������
	public void gotoHotelRoomManage() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelRoomManage.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelRoomManageController controller = (HotelRoomManageController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �Ƶ궩�����
	public void gotoHotelBrowseOrder() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("order/HotelBrowseOrder.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelBrowseOrderController controller = (HotelBrowseOrderController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �Ƶ궩��ִ��
	public void gotoHotelExecuteOrder() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("order/HotelExecuteOrder.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelExecuteOrderController controller = (HotelExecuteOrderController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �Ƶ귿����Ϣ����
	public void gotoHotelCheckIn() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelCheckIn.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelCheckInController controller = (HotelCheckInController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// �Ƶ����۲��Թ���
	public void gotoHotelStrategyManage() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelStrategy.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelStrategyController controller = (HotelStrategyController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ��ת����վӪ����Ա������
	public void gotoMarketOverview() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("market/MarketOverview.fxml"));
			rootLayout = (SplitPane) fxmlLoader.load();
			rootLayout.setPrefSize(1000, 600);
			rootLayout.setDividerPositions(0.3f);
			MarketOverviewController controller = (MarketOverviewController) fxmlLoader.getController();
			controller.setMain(this);
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ��վ���۲��Թ���
	public void gotoWebStrategyManage() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("market/MarketStrategy.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			MarketStrategyController controller = (MarketStrategyController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ��վӪ����Ա����쳣����
	public void gotoMarketAbnormalOrder() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("order/MarketBrowseAbnormalOrder.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			MarketBrowseAbnormalOrderController controller = (MarketBrowseAbnormalOrderController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ���ó�ֵ
	public void gotoMarketCreditCharge() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("market/CreditCharge.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			CreditChargeController controller = (CreditChargeController) fxmlLoader.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// ��ת����վ������Ա������
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
