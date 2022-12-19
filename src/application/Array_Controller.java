package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.LoginController.nextscene;


public class Array_Controller {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	

	dd aa = dd.getInstance();
	String filePath = "C:/자바 유저/"+aa.getUserid()+"의 일정.txt" ;
	String filePath3 = "C:/자바 유저/"+aa.getUserid()+"일정 숫자만.txt";
	int lineCount = 0;
	

	String info = "";
	int i=0,j=0,c=0;
	int error = 0,Dummy;
	static String []array_schedule = new String [3000];  // 일정 제목
	static int [] S_Year = new int [20]; // 년도
	static int [] S_Month = new int [20]; // 월
	static int [] S_Day = new int [20]; // 일
	static int [] S_O_clock = new int [20]; //시
	static int [] S_Min = new int [20]; // 분
	String[] info2 = new String[20];

	@FXML
	private TextField txtMsg1,txtMsg2,txtMsg3,txtMsg4,txtMsg5,txtMsg6;
	@FXML
	private TextArea textField;
	@FXML
	private Button btnAlert;
	
	public void clickHandler() throws IOException {
		


		
		Alert alert = new Alert(AlertType.INFORMATION);
		error = 0;
	     File file2 = new File(filePath3);
	     file2.createNewFile();
		 BufferedReader reader = new BufferedReader(new FileReader(filePath3));
         while (reader.readLine() != null) {
             lineCount++;
         }
         reader.close();
         String line;
         if(i==0) i = lineCount; 
         else if(i>lineCount)  i = c;
         
 		for(j=0; j<=i; j++)
 		{
 			
 			textField.appendText("일정" +" " +":"+" "+  array_schedule[j] +"	" +"["+ S_Year[j]+" 년 " + S_Month[j]+" 월 "+S_Day[j]+" 일 " + S_O_clock[j]+" 시 " + S_Min[j]+" 분" + "]"+"\n");
 		} 
 		

         BufferedReader br = new BufferedReader(new FileReader(filePath3));
         int a =0;
		 while((line = br.readLine()) != null) {
		 String[] intrd = line.split(" ");
		        array_schedule[a] = intrd[0];
				S_Year[a] = Integer.parseInt(intrd[1]);
				S_Month[a] = Integer.parseInt(intrd[2]);
				S_Day[a] = Integer.parseInt(intrd[3]);
				S_O_clock[a] = Integer.parseInt(intrd[4]);
				S_Min[a] = Integer.parseInt(intrd[5]);		
				a++;
				
			}
			
		 br.close();

         
         
		try
		{

			S_Year[i] = Integer.valueOf(txtMsg1.getText());
			S_Month[i] = Integer.valueOf(txtMsg2.getText());
			S_Day[i] = Integer.valueOf(txtMsg3.getText());
			S_O_clock[i] = Integer.valueOf(txtMsg4.getText());
			S_Min[i] = Integer.valueOf(txtMsg5.getText());
		}
		catch(NumberFormatException ex)
		{
			error = 1;
		}
         
         
		try
		{
			array_schedule[i] = txtMsg6.getText();
			
			if(txtMsg6.getText().trim().isEmpty())
			{
				Dummy = Integer.valueOf(txtMsg6.getText());
			}
		}
		catch(NumberFormatException ex)
		{
			array_schedule[i] = "일정 "+(i+1);
		}
		alert.setTitle("에러발생");
		if(error == 1)
		{
			alert.setContentText("에러발생 일정을 다시 확인해주세요");
			alert.show();
		}
		else if(S_Month[i]>12 || S_Month[i] <1)
		{
			alert.setContentText(S_Month[i]+"월은 존재하지 않습니다");
			alert.show();
		}
		else if(S_Day[i] > 31 || S_Day[i] <=0)
		{
			alert.setContentText(S_Day[i]+"일은 존재하지 않습니다");
			alert.show();
		}
		else if(((S_Month[i] == 4 || S_Month[i] == 6 || S_Month[i] == 9 || S_Month[i] == 11 ) && S_Day[i] > 30))
		{
			alert.setContentText(S_Month+"월에는"+S_Day[i]+"일이 없습니다");
			alert.show();
		}
		else if( !((S_Year[i] % 4 == 0 && S_Year[i] % 100 != 0) || S_Year[i] % 400 == 0) && (S_Month[i] == 2 && S_Day[i] == 29))
		{
			alert.setContentText(S_Year[i]+"년은 윤년이 아닙니다 ");
			alert.show();
		}
		else if(S_Month[i] == 2 && S_Day[i]> 29)
		{
			alert.setContentText(S_Month[i]+"월에는"+S_Day[i]+"일이 없습니다");
			alert.show();
		}
		else if(S_O_clock[i] >23 || S_O_clock[i] <0)
		{
			alert.setContentText(S_O_clock[i]+"시는 존재하지 않습니다");
			alert.show();
		}
		else if(S_Min[i] >59 || S_O_clock [i] <0)
		{
			alert.setContentText(S_Min[i]+"분은 존재하지 않습니다");
			alert.show();
		}
		else
		{
			for(j=i; j>0; j--)
			{
				if(S_Year[j] < S_Year[j-1])
				{
					swap(j);
				}
				else if(S_Year[j] > S_Year[j-1])
				{
					break;
				}
				else if( (S_Year[j] == S_Year[j-1]) && (S_Month[j] == S_Month[j-1]) && (S_Day[j] == S_Day[j-1]) && (S_O_clock[j] == S_O_clock[j-1]) && (S_Min[j] == S_Min[j-1]))
				{
					error = 2;
					break;
				}
				else
				{
					if(S_Month[j] < S_Month[j-1])
					{
						swap(j);
					}
					else if(S_Month[j] > S_Month[j-1])
					{
						break;
					}
					else
					{
						if(S_Day[j] < S_Day[j-1])
						{
							swap(j);
						}
						else if(S_Day[j] > S_Day[j-1])
						{
							break;
						}
						else
						{
							if(S_O_clock[j] < S_O_clock[j-1])
							{
								swap(j);
							}
							else if(S_O_clock[j] > S_O_clock[j-1])
							{
								break;
							}
							else
							{
								if(S_Min[j] < S_Min[j-1])
								{
									swap(j);
								}
								else if(S_Min[j] > S_Min[j-1])
								{
									break;
								}
								else
								{
									
								}
							}
						}
					}
				}
			}
			if(error != 0)
			{
				textField.clear();
				alert.setContentText(array_schedule[j]+"와 "+array_schedule[j-1]+"의 일정이 중첩되었습니다");
				alert.show();
				
				
			}
			
			else
			{
				
				
				textField.clear();
				for(j=0; j<=i; j++)
				{
					info2[j] =  array_schedule[j] +" "+S_Year[j] +" "+ S_Month[j]+" " + S_Day[j]+" " + S_O_clock[j]+" " + S_Min[j]+"\n";
					textField.appendText("일정" +" "+ ":"+" " + array_schedule[j] +" " +"["+ S_Year[j]+" 년 " + S_Month[j]+" 월 "+S_Day[j]+" 일 " + S_O_clock[j]+" 시 " + S_Min[j]+" 분" + "]"+"\n");
					
				} 
				i++;
				c = i;
			}
		}
		
	}
	public static void swap(int i) { 
	    int c = S_Year[i];
	    String [] D_array_schedule = new String [3000];
	    S_Year[i] = S_Year[i-1];
	    S_Year[i-1] = c;
	    
	    c = S_Month[i];
	    S_Month[i] = S_Month[i-1];
	    S_Month[i-1] = c;
	    
	    c = S_Day[i];
	    S_Day[i] = S_Day[i-1];
	    S_Day[i-1] = c;
	    
	    c = S_O_clock[i];
	    S_O_clock[i] = S_O_clock[i-1];
	    S_O_clock[i-1] = c;
	    
	    c = S_Min[i];
	    S_Min[i] = S_Min[i-1];
	    S_Min[i-1] = c;
	    
	    D_array_schedule[i] = array_schedule[i];
	    array_schedule[i] = array_schedule[i-1];
	    array_schedule[i-1] = D_array_schedule[i];
	}

	
	    @FXML
	    void SaveCL(ActionEvent event)throws IOException {// 저장 눌렀을때
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	
	     String A = textField.getText();	


	     File fl = new File(filePath); //원본 파일을 삭제했다가 일정 다시 입력
	     fl.delete();
	     fl.createNewFile();
	     FileWriter fw1 = new FileWriter(filePath,true); // 정상적인 파일 저장
	     fw1.write(A); 
	     fw1.close();
	        		  
    	 

	     
	     if(A != "") {
	    	 
		     File file2 = new File(filePath3);
		     System.gc();
		     System.runFinalization();
		     file2.delete();
		     System.out.println("삭제");
		     file2.createNewFile();
		     FileWriter fw2 = new FileWriter(filePath3,true);//숫자만 저장되는 파일에 숫자만 저장함

		     for(j=0; j<=i-1; j++) {
		        fw2.write(info2[j]); 
		     }
		     fw2.close();

		     
	     Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
	     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	     scene = new Scene(root);
	     stage.setScene(scene);
	     stage.show();
	     }

	     
	     
	   
	     if(A == "") {
	    	 alert.setContentText("일정을 입력해 주세요. ");
				alert.show();
	     }
	     
	        		    


	 }
	    
	    @FXML
	    void clickPr(ActionEvent event) throws IOException{ //계획된 일정 보기
	    	
	    	int lineCount2 = 0;
	    	int d =0;
	    	String line ="";
	    	
	    	BufferedReader reader = new BufferedReader(new FileReader(filePath3));
	         while (reader.readLine() != null) {
	             lineCount2++;
	         }
	         int e = lineCount2;
	         
	         
	         BufferedReader br = new BufferedReader(new FileReader(filePath3));
	         
			 while((line = br.readLine()) != null) {
			 String[] intrd = line.split(" ");
			        array_schedule[d] = intrd[0];
					S_Year[d] = Integer.parseInt(intrd[1]);
					S_Month[d] = Integer.parseInt(intrd[2]);
					S_Day[d] = Integer.parseInt(intrd[3]);
					S_O_clock[d] = Integer.parseInt(intrd[4]);
					S_Min[d] = Integer.parseInt(intrd[5]);		
					d++;
					
				}
			 textField.clear();
	    	
	    	for(int g=0; g<e; g++)
			{

				textField.appendText("일정" +" " +":"+" "+  array_schedule[j] +"	" +"["+ S_Year[g]+" 년 " + S_Month[g]+" 월 "+S_Day[g]+" 일 " + S_O_clock[g]+" 시 " + S_Min[g]+" 분" + "]"+"\n");
			} 
	    	
	    	br.close();

	    }
	    
	    @FXML
	    void Back(ActionEvent event) throws IOException{
	    	
		     Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		     scene = new Scene(root);
		     stage.setScene(scene);
		     stage.show();

	    }
	            
	   

			    
			
		 

	    }
	    

