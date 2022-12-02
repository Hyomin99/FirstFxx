package application;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField crtID;
    @FXML
    private PasswordField crtPW;
    @FXML
    private Label IDCheck;

	

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
		
		String ID = crtID.getText();
		String PW = crtPW.getText();
		
		//Sign Up 누르면 텍스트 파일 생성
		FileWriter fw = new FileWriter("C:/Users/효민/Desktop/SignUp/UserID.txt",true);
		fw.write(ID +"\n");
	    fw.close();
	    FileWriter fw2 = new FileWriter("C:/Users/효민/Desktop/SignUp/UserIDPW.txt",true);
	    fw2.write(ID +" " + PW +"\n");
	    fw2.close();
		

	    
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
	  
	  @FXML // 중복확인 눌렀을때 중복인지 아닌지 검사
	  void checkID(ActionEvent event)throws IOException {
		  String ID = crtID.getText();
		  BufferedReader br = new BufferedReader(new FileReader("C:/Users/효민/Desktop/SignUp/UserID.txt"));
		  
		  //텍스트에 입력한 문자열과 메모장에 입력되어있는 문자열 비교
		  while(true) { 
			  
			  String line = br.readLine();
			  
				  if(ID.equals(line)){  
					  IDCheck.setText("중복된 아이디 입니다. "); 
					  break;
					  }
				  
				  else if(line==null) {
					  
					 IDCheck.setText("사용 가능한 아이디 입니다. ");
					  break; 
					  }	  
		  }
		  br.close();
	  }
	 
}
