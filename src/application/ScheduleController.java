package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import application.LoginController.nextscene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ScheduleController {
	
	@FXML
    private TextArea textArea;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
    @FXML
    private TextField Linebox;
	
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
	void ClShow(ActionEvent event)throws IOException {

    	int a = 0;
		dd aa = dd.getInstance(); 
		String filePath = "C:/자바 유저/"+aa.getUserid()+"의 일정.txt" ; 
        File file = new File(filePath); //파일 객체 생성
        FileReader filereader = new FileReader(file); //입력 스트림 생성
        BufferedReader bufReader = new BufferedReader(filereader); //입력 버퍼 생성
        String line = ""; // 라인
        while((line = bufReader.readLine()) != null){ // 출력하기
        	textArea.appendText(line+"\n");
        }
         bufReader.close();

	 
	}
	
	  @FXML
	    void BackMain(ActionEvent event) throws IOException { // 취소 누르면 메인페이지로 복귀
		  nextscene ns = new nextscene(event,"/application/Main.fxml");
	  }

	    


	    @FXML
	    void DeleteSd(ActionEvent event) throws IOException {
	    	nextscene ns = new nextscene(event,"/application/DeleteSD.fxml");

	    }

	    @FXML
	    void EditSd(ActionEvent event) throws IOException {
	    	nextscene ns = new nextscene(event,"/application/EditSD.fxml");

	    }
	    
	    @FXML
	    void BacktoShow(ActionEvent event) throws IOException {
	    	
	    	int num = Integer.parseInt(Linebox.getText()); //지우고 싶은 줄 -1 해줘야함
	    	System.out.println(num);
	    	dd aa = dd.getInstance();
	    	String filePath = "C:/자바 유저/"+aa.getUserid()+"의 일정.txt" ; // 읽을 파일 위치
	    	String filePath2 = "C:/자바 유저/"+aa.getUserid()+"일정 숫자만.txt"; // 읽을 파일 위치
	    	int i = 0;
	    	int l = 0;
	    	
	    	String line;
	    	String line2;
	    	String[] textline = new String[20];
	    	String[] intline = new String[20];
	    	
	    	File file = new File(filePath); //파일 객체 생성
	        FileReader filereader = new FileReader(file); //입력 스트림 생성
	        BufferedReader bufReader = new BufferedReader(filereader); //입력 버퍼 생성

	        while ((line=bufReader.readLine()) != null) {
	        	textline[i]=line;
	             i++;
	         }
	        bufReader.close();
	        file.delete();
	        file.createNewFile();
	        
	        FileWriter fw = new FileWriter(filePath,true); //다시 쓸 준비

	        for(int a = 0; a<num-1 ; a++) {
	        	fw.write(textline[a]+"\n");
	        }
	        for(int a = num; a<i ; a++) {
	        	fw.write(textline[a]+"\n");
	        }
	        fw.close();
	        
	        
	        File file2 = new File(filePath2); //파일 객체 생성
	        FileReader filereader2 = new FileReader(file2); //입력 스트림 생성
	        BufferedReader bufReader2 = new BufferedReader(filereader2); //입력 버퍼 생성
	        
	        while ((line2=bufReader2.readLine()) != null) {
	        	intline[l]=line2;
	        	 l++;
	        } 
	        bufReader2.close();
	        file2.delete();
	        file2.createNewFile();

	        FileWriter fw2 = new FileWriter(filePath2,true); //다시 쓸 준비

	        for(int b = 0; b<num-1 ; b++) {
	        	fw2.write(intline[b]+"\n");
	        }
	        for(int b = num; b<l ; b++) {
	        	fw2.write(intline[b]+"\n");
	        }
	        fw2.close();


	        
	    	nextscene ns = new nextscene(event,"/application/ViewSchedule.fxml");

	    }


//만약 6개의 줄이 있는데 3번째 줄을 지우고 싶음 배열은 0 1 2 이렇게 저장이 되어 있는데 [2]에 있는 값을 없애고 싶은거야 그럼 [0] 과 [1]을 읽어서 저장해 그리고 [2]를 띄어 넘고 [3]부터 [5]까지를 읽어서 저장해야함
}
