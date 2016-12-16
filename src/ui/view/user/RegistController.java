package ui.view.user;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import objects.ResultMessage;
import rmi.RemoteHelper;
import ui.util.AlertUtil;
import ui.view.Main;

public class RegistController implements Initializable {
	private Main main;
	private String type;

	RemoteHelper helper = RemoteHelper.getInstance();
	@FXML
	private TextField usernameTextField;

	@FXML
	private TextField passwordTextField1;

	@FXML
	private TextField passwordTextField2;

	public RegistController() {

	}

	public void setMain(Main main, String type) {
		this.main = main;
		this.type = type;
	}

	@FXML
	private void cancelRegist(ActionEvent event) {
		main.gotoLogin(type);
	}

	@FXML
	private void register() throws RemoteException {
		if (passwordTextField1.getText().equals(passwordTextField2.getText())) {
			ResultMessage result = helper.getClientBLService().client_register(usernameTextField.getText(),
					passwordTextField1.getText());
			if (result == ResultMessage.Success) {
				AlertUtil.showInformationAlert("注册成功！");
				main.gotoLogin("client");
			} else {
				AlertUtil.showErrorAlert("对不起，注册失败，可能是用户名冲突或者网络问题。");
			}
		}

		else {
			AlertUtil.showWarningAlert("对不起，您两次输入的密码不一样");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
