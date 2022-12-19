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

    @FXML
    private TextField ClockTb;

    @FXML
    private TextField DayTb;

    @FXML
    private TextField MinTb;

    @FXML
    private TextField MonthTb;

    @FXML
    private TextField NumBox;

    @FXML
    private TextField SceduleTb;

    @FXML
    private TextField YearTb;
	
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

	    @FXML
	    void Editbt(ActionEvent event) throws IOException{
	    	int num = Integer.parseInt(NumBox.getText()); //년도
	    	String scedule = SceduleTb.getText(); //일정
	    	int year = Integer.parseInt(YearTb.getText()); //년도
	    	int month = Integer.parseInt(MonthTb.getText()); //월
	    	int day = Integer.parseInt(DayTb.getText()); // 일
	    	int clock = Integer.parseInt(ClockTb.getText()); //시간
	    	int min = Integer.parseInt(MinTb.getText()); //분
	    	
	    	System.out.println(num);
	    	
	    	dd aa = dd.getInstance();
	    	String filePath = "C:/자바 유저/"+aa.getUserid()+"의 일정.txt" ; // 일정 파일 위치
	    	String filePath2 = "C:/자바 유저/"+aa.getUserid()+"일정 숫자만.txt"; // 일정 숫자 파일 위치
	    			
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
	        	textline[i]=line; //원본 파일을 읽어서 TEXTLINE에 저장
	             i++;
	         }
	        bufReader.close();
	        file.delete();
	        file.createNewFile();
	        
	        FileWriter fw = new FileWriter(filePath,true); //다시 쓸 준비

	        for(int a = 0; a<num-1 ; a++) { //사용자가 원하는 행보다 낮은 위치에 있는 일정을 다시 씀
	        	fw.write(textline[a]+"\n");
	        }
	        
	        textline[num-1] = "일정" +" "+ ":"+" " + scedule +" " +"["+ year+" 년 " + month+" 월 "+day+" 일 " + clock+" 시 " + min+" 분" + "]"+"\n"; //사용자가 수정하길 원하는 일정을 원하는 행에 다시 작성함
	        fw.write(textline[num-1]);
	        
	        for(int a = num; a<i ; a++) { //원하는 행 다음에 있는 데이터를 다시 써줌
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
	        
	        intline[num-1] =  scedule +" "+year +" "+ month+" " + day+" " + clock+" " + min+"\n";; //사용자가 수정하길 원하는 일정을 원하는 행에 다시 작성함
	        fw2.write(intline[num-1]);
	        
	        for(int b = num; b<l ; b++) {
	        	fw2.write(intline[b]+"\n");
	        }
	        fw2.close();


	        
	    	nextscene ns = new nextscene(event,"/application/ViewSchedule.fxml");


	    }
}
