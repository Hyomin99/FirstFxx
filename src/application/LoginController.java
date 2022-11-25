package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;



public class LoginController {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Window window;
	
    @FXML
    private Button cancelButton;

    @FXML
    private GridPane loginScene;

	
	private Parent root;
	
	@FXML
	void swichToSignUp(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/SignUp.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
    void swichToLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	 void close(ActionEvent event) {
	  stage = (Stage)loginScene.getScene().getWindow();
	  System.out.println("");
	  stage.close();
	}
}



