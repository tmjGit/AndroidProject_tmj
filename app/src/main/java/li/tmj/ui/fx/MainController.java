//package li.tmj.ui.fx;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.application.Platform;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import li.tmj.ui.lang.Localization;
//
//public class MainController implements Initializable {
//	@FXML Button personenBt;
//	@FXML Button quitBt;
//
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		setFxText();
//	}
//
//	private void setFxText() {
//		personenBt.setText(Localization.get("Persons"));
//		quitBt.setText(Localization.get("Quit"));;
//	}
//
//	@FXML
//	private void personenBtAction(javafx.event.ActionEvent event) throws IOException {
//		FxScene.PERSON.showOnNewStage();
//		FxManager.closeMyStage((Button) event.getSource());
//	}
//
//	@FXML private void quitBtAction() {
//		Platform.exit();
//	}
//}
//
//
