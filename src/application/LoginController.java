package application;

import java.io.BufferedReader;
import java.io.File;
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
    @FXML
    private Label WrongPW;
    @FXML
    private TextField InputID;
    @FXML
    private PasswordField InputPW;
    
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
	void swichToSignUp(ActionEvent event) throws IOException {//회원가입 버튼 누르면 회원가입 페이지로 넘어감
		nextscene ns = new nextscene(event,"/application/SignUp.fxml");
	}

	@FXML 
	void swichToLogin(ActionEvent event) throws IOException {//회원가입 페이지에서 제출하면 로그인 페이지로 넘어감 
		
		
		  String ID = crtID.getText();
		  String PW = crtPW.getText();
		  
		  BufferedReader br = new BufferedReader(new FileReader("C:/자바 유저/UserID.txt"));
		  
		  while(true) {//제출 눌렀을때 모든 조건 충족할 시 저장
			  
			  String line = br.readLine();
			  
		if( ID.isBlank() == true || PW.isBlank() == true) {IDCheck.setText("확인 버튼을 누른 뒤 진행해 주세요."); break;}
		else if(IDCheck.getText().equals("중복된 아이디 입니다. ")||IDCheck.getText().equals("")) {IDCheck.setText("확인 버튼을 누른 뒤 진행해 주세요."); break;}
		else {
		FileWriter fw = new FileWriter("C:/자바 유저/UserID.txt",true);
		fw.write(ID +"\n");
	    fw.close();
	    FileWriter fw2 = new FileWriter("C:/자바 유저/UserIDPW.txt",true);
	    fw2.write(ID +" " + PW +"\n");
	    fw2.close();
	    br.close();
	    nextscene ns = new nextscene(event,"/application/Login.fxml");
	    break;
		}
	  }
	}

	  @FXML 
	void close(ActionEvent event) throws IOException { // 종료 버튼 누르면 나가길 원하느냐는 창으로 넘어감
	    nextscene ns = new nextscene(event,"/application/Check.fxml");
	}
	
	  @FXML 
    void check(ActionEvent event) {//yes 버튼 누를시 창을 꺼버림
		stage = (Stage)checkscene.getScene().getWindow(); 
		System.out.println("");
	    stage.close();
	  
	}
	  
	  @FXML 
    void goback(ActionEvent event)throws IOException { //no버튼 누르면 다시 로그인창으로 되돌아가기
		nextscene ns = new nextscene(event,"/application/Login.fxml");
	  }
	  
	  @FXML 
    void checkID(ActionEvent event)throws IOException {// 중복확인 눌렀을때 중복인지 아닌지 검사

		  String ID = crtID.getText();
		  String PW = crtPW.getText();
		  BufferedReader br = new BufferedReader(new FileReader("C:/자바 유저/UserID.txt"));
		
		  //텍스트에 입력한 문자열과 메모장에 입력되어있는 문자열 비교
		  while(true) { 
			  
			  String line = br.readLine();
			  
				  if(ID.equals(line)) {IDCheck.setText("중복된 아이디 입니다. "); break;} //중복 아이디
				  else if(line==null) {IDCheck.setText("사용 가능한 아이디 입니다. "); break; } // 아이디 사용 가능
				  else if (ID.isBlank() == true) {IDCheck.setText("아이디를 입력해 주세요. "); break;} // 아이디 공백 있을시
				  else if (PW.isBlank() == true) {IDCheck.setText("비밀번호를 입력해 주세요."); break;} //비밀번호 입력 안했을시
				  
		 
		  
	  }
		  br.close();
   }

	@FXML  
	public void LoginClick(ActionEvent event)throws IOException {
		
		
		String ID = InputID.getText();
		String PW = InputPW.getText();
		String line;
		boolean IDtrue = false;
		boolean PWtrue = false;
		BufferedReader br = new BufferedReader(new FileReader("C:/자바 유저/UserIDPW.txt"));
		

			while((line = br.readLine()) != null) {
				
				String[] IDPW = line.split(" ");
				IDtrue = ID.equals(IDPW[0]);
				PWtrue = PW.equals(IDPW[1]);
				
				if((IDtrue == true && PWtrue == true) == true) {
					
					String filePath = "C:/자바 유저/"+InputID.getText()+"의 일정.txt"; 
					String userid = InputID.getText();
					aa.setUserid(userid);
					
					File file = new File(filePath); //만들 로그인 한 사람의 일정 계획 텍스트 파일
					
					if(!file.exists()){ // 텍스트 파일이 존재하지 않다면
			            file.createNewFile(); // 텍스트파일 생성
			            nextscene ns = new nextscene(event,"/application/Main.fxml");
			            break;
			        }
					
					else if(file.exists()) { //텍스트 파일이 존재한다면
						nextscene ns = new nextscene(event,"/application/Main.fxml"); //그냥 다음 페이지로
					    break;
					}
					
				} // 옳은 정보일 시 화면전환
				
				else if((IDtrue == false && PWtrue == false) == true){WrongPW.setText("정보가 없습니다.");} // 잘못입력
				
			}
			br.close();
					
		}
		
		
	
	}
		  
	  


	 

