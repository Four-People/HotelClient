package ui.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import rmi.RemoteHelper;
import runner.ClientRunner;
import ui.model.HotelModel;
import ui.model.OrderModel;
import ui.view.client.ClientBasicInfoController;
import ui.view.client.ClientBrowseHotelController;
import ui.view.client.ClientEnrollVIPController;
import ui.view.client.ClientEvaluateHotelController;
import ui.view.client.ClientOverviewController;
import ui.view.client.ClientSearchHotelController;
import ui.view.hotel.HotelBasicInfoController;
import ui.view.hotel.HotelCheckInChoiceController;
import ui.view.hotel.HotelCheckInController;
import ui.view.hotel.HotelDetailInfoController;
import ui.view.hotel.HotelOverviewController;
import ui.view.hotel.HotelRoomManageController;
import ui.view.hotel.HotelStrategyController;
import ui.view.manager.ManagerOverviewController;
import ui.view.market.CreditChargeController;
import ui.view.market.MarketOverviewController;
import ui.view.market.MarketStrategyController;
import ui.view.order.AbnormalOrderDetailInfoByClientController;
import ui.view.order.ClientBrowseOrderController;
import ui.view.order.ClientGenerateOrderController;
import ui.view.order.FilledOrderDetailInfoByClientController;
import ui.view.order.HotelBrowseOrderController;
import ui.view.order.MarketBrowseAbnormalOrderController;
import ui.view.order.OrderDetailInfoByHotelController;
import ui.view.order.UnfilledOrderDetailInfoByClientController;
import ui.view.user.LoginController;
import ui.view.user.LoginOverviewController;
import ui.view.user.RegistController;
import ui.view.user.UpdatePasswordController;
import vo.ClientVO;
import vo.HotelVO;
import vo.HotelWorkerVO;
import vo.OrderVO;
import vo.WebManagerVO;
import vo.WebMarketVO;

public class Main extends Application {
	// 主窗口
	private Stage stage;

	// 弹窗
	private Stage extraStage;
	private Stage extraStage2;

	// 内部窗口
	private SplitPane rootLayout;

	private Scene scene;
	private final double MINIMUM_WINDOW_WIDTH = 400.0;
	private final double MINIMUM_WINDOW_HEIGHT = 250.0;
	
	RemoteHelper helper=RemoteHelper.getInstance();

	/*
	 * an observable list of hotels.
	 */
	private ObservableList<HotelModel> hotelData = FXCollections.observableArrayList();

	public Main() {
		
	}

	public ObservableList<HotelModel> getHotelData() {
		return hotelData;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("Hotel");
		stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
		stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
		stage.setResizable(false);
		initUI();
		stage.show();
	}

	/**
	 * 初始界面
	 */
	public void initUI() {
		try {

			LoginOverviewController loginOverviewController = (LoginOverviewController) replaceSceneContent(
					"user/LoginOverView.fxml");
			loginOverviewController.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * 退出系统
	 */
	public void exitSystem(){
		stage.close();
		closeExtraStage();
	}
	/**
	 * 返回主界面
	 */
	public void backtoMain(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("user/LoginOverview.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
			this.scene = new Scene(pane);
			LoginOverviewController overviewController = (LoginOverviewController) loader.getController();
			overviewController.setMain(this);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.centerOnScreen();
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  跳转到登录界面
	 * @param type
	 */
	public void gotoLogin(String type) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("user/Login.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
			this.scene = new Scene(pane);
			LoginController loginController = (LoginController) loader.getController();
			loginController.setMain(this, type);

			// 当非客户用户登录时，隐藏注册按钮
			if (type != "client") {
				loginController.getRegistButton().setVisible(false);
			}

			stage.setScene(scene);
			stage.sizeToScene();
			stage.centerOnScreen();
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  跳转到注册界面
	 * @param type
	 */
	public void gotoRegist(String type) {
		try {
			RegistController registController = (RegistController) replaceSceneContent("user/Regist.fxml");
			registController.setMain(this, type);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * 跳转到修改密码界面
	 * @param type
	 */
	public void gotoUpdatePassword(String type) {
		try {
			UpdatePasswordController controller = (UpdatePasswordController) replaceSceneContent(
					"user/UpdatePassword.fxml");
			controller.setMain(this, type);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  跳转到客户主界面
	 * @param clientVO
	 */
	public void gotoClientOverview(ClientVO clientVO) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientOverview.fxml"));
			rootLayout = (SplitPane) fxmlLoader.load();
			rootLayout.setPrefSize(1000, 600);
			rootLayout.setDividerPositions(0.3f);
			ClientOverviewController controller = (ClientOverviewController) fxmlLoader.getController();
			controller.setMain(this,clientVO);
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  客户查看基本信息
	 * @param clientVO
	 * @param clientOverviewController
	 */
	public void gotoClientBasicInfo(ClientVO clientVO,ClientOverviewController clientOverviewController) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientBasicInfo.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientBasicInfoController controller = (ClientBasicInfoController) fxmlLoader.getController();
			controller.setMain(this,clientVO,clientOverviewController);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * 客户浏览酒店
	 * @param clientVO
	 */
	public void gotoClientBrowseHotel(ClientVO clientVO) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientBrowseHotel.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientBrowseHotelController controller = (ClientBrowseHotelController) fxmlLoader.getController();
			controller.setMain(this,clientVO);
			stage.centerOnScreen();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  客户浏览订单
	 * @param clientid
	 */
	public void gotoClientBrowseOrder(int clientid) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("order/ClientBrowseOrder.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientBrowseOrderController controller = (ClientBrowseOrderController) fxmlLoader.getController();
			controller.setMain(this,clientid);
			stage.centerOnScreen();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	/**
	 * 客户查看已执行的订单
	 * @param order
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void gotoClientExecuteOrder(OrderModel order) throws NumberFormatException, IOException{
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(Main.class.getResource("order/FilledOrderDetailInfoByClient.fxml"));
		AnchorPane insidePane = (AnchorPane) fxmlLoader.load();

		FilledOrderDetailInfoByClientController controller = (FilledOrderDetailInfoByClientController) fxmlLoader.getController();
		OrderVO ordervo=helper.getOrderBLService().order_findbyid(Integer.parseInt(order.getOrderid()));
		controller.setMain(this,ordervo);

		extraStage = new Stage(StageStyle.UNDECORATED);
		extraStage.setScene(new Scene(insidePane));
		extraStage.setAlwaysOnTop(true);
		extraStage.centerOnScreen();
		extraStage.show();
	}
	
	/**
	 * 客户查看未执行订单
	 * @param order
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void gotoClientNoExecuteOrder(OrderModel order) throws NumberFormatException, IOException{
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(Main.class.getResource("order/UnfilledOrderDetailInfoByClient.fxml"));
		AnchorPane insidePane = (AnchorPane) fxmlLoader.load();

		UnfilledOrderDetailInfoByClientController controller = (UnfilledOrderDetailInfoByClientController) fxmlLoader.getController();
		OrderVO ordervo=helper.getOrderBLService().order_findbyid(Integer.parseInt(order.getOrderid()));
		controller.setMain(this,ordervo);

		extraStage = new Stage(StageStyle.UNDECORATED);
		extraStage.setScene(new Scene(insidePane));
		extraStage.setAlwaysOnTop(true);
		extraStage.centerOnScreen();
		extraStage.show();
	}
	
	/**
	 * 客户查看异常或撤销订单
	 * @param order
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void gotoClientAbnormalOrder(OrderModel order) throws NumberFormatException, IOException{
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(Main.class.getResource("order/AbnormalOrderDetailInfoByClient.fxml"));
		AnchorPane insidePane = (AnchorPane) fxmlLoader.load();

		AbnormalOrderDetailInfoByClientController controller = (AbnormalOrderDetailInfoByClientController) fxmlLoader.getController();
		OrderVO ordervo=helper.getOrderBLService().order_findbyid(Integer.parseInt(order.getOrderid()));
		controller.setMain(this,ordervo);

		extraStage = new Stage(StageStyle.UNDECORATED);
		extraStage.setScene(new Scene(insidePane));
		extraStage.setAlwaysOnTop(true);
		extraStage.centerOnScreen();
		extraStage.show();
	}

	/**
	 *  客户注册会员
	 * @param vo
	 * @param overviewcontroller
	 */
	public void gotoClientEnrollVIP(ClientVO vo,ClientOverviewController overviewcontroller) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientEnrollVIP.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientEnrollVIPController controller = (ClientEnrollVIPController) fxmlLoader.getController();
			controller.setMain(this,vo,overviewcontroller);
			stage.centerOnScreen();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * 客户评价酒店
	 * @param client
	 * @param hotel
	 */
	public void gotoClientEvaluateHotel(ClientVO client,HotelVO hotel,OrderVO order) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientEvaluateHotel.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();

			ClientEvaluateHotelController controller = (ClientEvaluateHotelController) fxmlLoader.getController();
			controller.setMain(this,client,hotel,order);

			extraStage2 = new Stage(StageStyle.UNDECORATED);
			extraStage2.setScene(new Scene(insidePane));
			extraStage2.setAlwaysOnTop(true);
			extraStage2.centerOnScreen();
			extraStage2.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  客户搜索酒店
	 * @param clientVO
	 */
	public void gotoClientSearchHotel(ClientVO clientVO) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("client/ClientSearchHotel.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			ClientSearchHotelController controller = (ClientSearchHotelController) fxmlLoader.getController();
			controller.setMain(this,clientVO);
			stage.centerOnScreen();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * 客户查看酒店详细信息
	 * @param hotel
	 */
	public void gotoHotelDetailInfo(HotelVO hotel,int clientid) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelDetailInfo.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();

			HotelDetailInfoController controller = (HotelDetailInfoController) fxmlLoader.getController();
			controller.setMain(this,hotel,clientid);

			extraStage2 = new Stage(StageStyle.UNDECORATED);
			extraStage2.setScene(new Scene(insidePane));
			extraStage2.centerOnScreen();
			extraStage2.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// 客户生成订单
	public void gotoGenerateOrder(HotelVO hotel,ClientVO client) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("order/ClientGenerateOrder.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();

			ClientGenerateOrderController controller = (ClientGenerateOrderController) fxmlLoader.getController();
			controller.setMain(this, hotel,client);

			extraStage = new Stage(StageStyle.UNDECORATED);
			extraStage.setScene(new Scene(insidePane));
			extraStage.centerOnScreen();
			extraStage.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * 跳转到酒店主界面
	 * @param hotelworkervo
	 * @param hotelvo
	 */
	public void gotoHotelOverview(HotelWorkerVO hotelworkervo,HotelVO hotelvo) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelOverview.fxml"));
			rootLayout = (SplitPane) fxmlLoader.load();
			rootLayout.setPrefSize(1000, 600);
			rootLayout.setDividerPositions(0.3f);
			HotelOverviewController controller = (HotelOverviewController) fxmlLoader.getController();
			controller.setMain(this,hotelworkervo,hotelvo);
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	
	 /**
	  * 酒店工作人员管理酒店信息
	  * @param vo
	  * @param overviewController
	  */
	public void gotoHotelBasicInfo(HotelVO vo,HotelOverviewController overviewController) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelBasicInfo.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelBasicInfoController controller = (HotelBasicInfoController) fxmlLoader.getController();
			controller.setMain(this,vo,overviewController);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  酒店可用房间管理
	 * @param hotelVO
	 */
	public void gotoHotelRoomManage(HotelVO hotelVO) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelRoomManage.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelRoomManageController controller = (HotelRoomManageController) fxmlLoader.getController();
			controller.setMain(this,hotelVO);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  酒店订单浏览
	 * @param hotelid
	 */
	public void gotoHotelBrowseOrder(int hotelid) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("order/HotelBrowseOrder.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelBrowseOrderController controller = (HotelBrowseOrderController) fxmlLoader.getController();
			controller.setMain(this,hotelid);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * 酒店查看订单详细信息
	 * @param orderVO
	 */
	public void gotoHotelDetailOrder(OrderModel order){
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("order/OrderDetailInfoByHotel.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();

			OrderDetailInfoByHotelController controller = (OrderDetailInfoByHotelController) fxmlLoader.getController();
			OrderVO orderVO=helper.getOrderBLService().order_findbyid(Integer.parseInt(order.getOrderid()));
			controller.setMain(this,orderVO);

			extraStage = new Stage(StageStyle.UNDECORATED);
			extraStage.setScene(new Scene(insidePane));
			extraStage.centerOnScreen();
			extraStage.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  酒店房间信息更新
	 * @param hotelVO
	 */
	public void gotoHotelCheckIn(HotelVO hotelVO) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelCheckIn.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelCheckInController controller = (HotelCheckInController) fxmlLoader.getController();
			controller.setMain(this,hotelVO);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	/**
	 * 入住退房弹窗
	 * @param hotelCheckInController
	 */
	public void gotoHotelCheckInChoice(HotelCheckInController hotelCheckInController){
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelCheckInChoice.fxml"));
			AnchorPane pane;
			pane = (AnchorPane) fxmlLoader.load();
			pane.setPrefSize(300,200);
			
			HotelCheckInChoiceController controller = (HotelCheckInChoiceController) fxmlLoader.getController();
			controller.setMain(this, hotelCheckInController);
			
			extraStage = new Stage(StageStyle.UNDECORATED);
			extraStage.setScene(new Scene(pane));
			extraStage.centerOnScreen();
			extraStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 酒店销售策略管理
	 * @param hotelVO
	 */
	public void gotoHotelStrategyManage(HotelVO hotelVO) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("hotel/HotelStrategy.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			HotelStrategyController controller = (HotelStrategyController) fxmlLoader.getController();
			controller.setMain(this,hotelVO);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  跳转到网站营销人员主界面
	 * @param vo
	 */
	public void gotoMarketOverview(WebMarketVO vo) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("market/MarketOverview.fxml"));
			rootLayout = (SplitPane) fxmlLoader.load();
			rootLayout.setPrefSize(1000, 600);
			rootLayout.setDividerPositions(0.3f);
			MarketOverviewController controller = (MarketOverviewController) fxmlLoader.getController();
			controller.setMain(this,vo);
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  网站销售策略管理
	 */
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

	/**
	 *  网站营销人员浏览异常订单
	 */
	public void gotoMarketAbnormalOrder() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("order/MarketBrowseAbnormalOrder.fxml"));
			AnchorPane insidePane = (AnchorPane) fxmlLoader.load();
			insidePane.setPrefSize(700, 600);
			rootLayout.getItems().set(1, insidePane);
			MarketBrowseAbnormalOrderController controller = (MarketBrowseAbnormalOrderController) fxmlLoader
					.getController();
			controller.setMain(this);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  信用充值
	 */
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

	/**
	 *  跳转到网站管理人员主界面
	 * @param vo
	 */
	public void gotoManagerOverview(WebManagerVO vo) {
		try {
			ManagerOverviewController ManagerOverviewController = (ManagerOverviewController) replaceSceneContent(
					"manager/ManagerOverview.fxml");
			ManagerOverviewController.setMain(this,vo,stage);
		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 *  界面跳转
	 * @param fxml
	 * @return
	 * @throws Exception
	 */
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

	/**
	 *  关闭弹窗
	 */
	public void closeExtraStage() {
		if (extraStage2!=null&&extraStage2.isShowing()) {
			extraStage2.hide();
		}
		if (extraStage!=null&&extraStage.isShowing()) {
			extraStage.hide();
		}
	}

	public Stage getPrimaryStage() {
		return stage;
	}

	public static void main(String[] args) {
		
		launch(args);
	}

}