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
import javafx.scene.layout.Pane;
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
	private Button yesbutton;
	@FXML
	private Button nobutton;
	@FXML
	private GridPane loginscene;
	@FXML
	private Pane checkscene;
	

	// private Parent root;

	@FXML //Sign Up 버튼 누르면 SignUp 페이지로 넘어감
	void swichToSignUp(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/SignUp.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML //Sign Up 페이지에서 submit 누르면 Login 페이지로 넘어감 
	void swichToLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	
	  @FXML // cancel 버튼 누르면 나가길 원하느냐는 창으로 넘어감
	  void close(ActionEvent event) throws IOException { 
	    Parent root =FXMLLoader.load(getClass().getResource("/application/Check.fxml")); 
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    scene = new Scene(root); 
	    stage.setScene(scene); 
	    stage.show(); 
	}
	
	  @FXML //yes 버튼 누를시 창을 꺼버림
	  void check(ActionEvent event) {
		stage = (Stage)checkscene.getScene().getWindow(); 
		System.out.println("");
	    stage.close();
	  
	}
	  
	  @FXML //no버튼 누르면 다시 로그인창으로 되돌아가기
	  void goback(ActionEvent event)throws IOException { 
		Parent root =FXMLLoader.load(getClass().getResource("/application/Login.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root); 
		stage.setScene(scene); 
		stage.show(); 
	  }
	  
	 
}
