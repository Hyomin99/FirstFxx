package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainController {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Window window;
	@FXML
	private Pane checkscene;
	@FXML
	private Button yesbutton;
	@FXML
	private Button nobutton;
	
	dd aa = dd.getInstance();
	
	class nextscene {//다음 페이지로 넘어가는 복사코드
		
		String fxml;
		
		public nextscene(ActionEvent event, String fxml) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource(this.fxml = fxml));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
	
    @FXML
    void ViewSD(ActionEvent event) throws IOException { // 일정 보기 누를시 일정 확인하는 페이지로 넘어감
    	nextscene ns = new nextscene(event,"/application/ViewSchedule.fxml");
    	System.out.println(aa.getFilepath());
    	
    }
	
	@FXML
    void CalendarCL(ActionEvent event) throws IOException { //일정 등록 누를시 일정 등록하는 페이지로 넘어감
		nextscene ns = new nextscene(event,"/application/Array.fxml");	
	}
	
	
	
	@FXML
    void CheckOut(ActionEvent event)throws IOException { // 종료 버튼 누르면 나가길 원하느냐는 창으로 넘어감
		    nextscene ns = new nextscene(event,"/application/Check2.fxml");
    }
	
	
	@FXML 
    void check(ActionEvent event) {//yes 버튼 누를시 창을 꺼버림
		stage = (Stage)checkscene.getScene().getWindow(); 
	    stage.close();
	}
	  
	@FXML 
    void goback(ActionEvent event)throws IOException { //no 버튼 누룰시 그자리에 남음
		nextscene ns = new nextscene(event,"/application/Main.fxml");
	  }
}













