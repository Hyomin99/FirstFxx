package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Array_Controller {
	int i=0,j=0,error = 0,Dummy;
	static String []array_schedule = new String [3000]; 
	static int [] S_Year = new int [20];
	static int [] S_Month = new int [20];
	static int [] S_Day = new int [20];
	static int [] S_O_clock = new int [20];
	static int [] S_Min = new int [20];

	@FXML
	private TextField txtMsg1,txtMsg2,txtMsg3,txtMsg4,txtMsg5,txtMsg6;
	@FXML
	private TextArea textField;
	@FXML
	private Button btnAlert;
	
	public void clickHandler() {
		Alert alert = new Alert(AlertType.INFORMATION);
		error = 0;
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
			alert.setContentText("숫자만 입력해주세요.");
			alert.show();
		}
		else if(S_Month[i]>12 || S_Month[i] <1)
		{
			alert.setContentText(S_Month[i]+"월은 존재하지 않습니다.");
			alert.show();
		}
		else if(S_Day[i] > 31 || S_Day[i] <=0)
		{
			alert.setContentText(S_Day[i]+"일은 존재하지 않습니다.");
			alert.show();
		}
		else if(((S_Month[i] == 4 || S_Month[i] == 6 || S_Month[i] == 9 || S_Month[i] == 11 ) && S_Day[i] > 30))
		{
			alert.setContentText(S_Month+"월에는 "+S_Day[i]+"일이 없습니다.");
			alert.show();
		}
		else if( !((S_Year[i] % 4 == 0 && S_Year[i] % 100 != 0) || S_Year[i] % 400 == 0) && (S_Month[i] == 2 && S_Day[i] == 29))
		{
			alert.setContentText(S_Year[i]+"년은 윤년이 아닙니다 ");
			alert.show();
		}
		else if(S_Month[i] == 2 && S_Day[i]> 29)
		{
			alert.setContentText(S_Month[i]+"월에는 "+S_Day[i]+"일이 없습니다");
			alert.show();
		}
		else if(S_O_clock[i] >23 || S_O_clock[i] <0)
		{
			alert.setContentText(S_O_clock[i]+"시는 존재하지않습니다");
			alert.show();
		}
		else if(S_Min[i] >59 || S_O_clock [i] <0)
		{
			alert.setContentText(S_Min[i]+"분은 존재하지않습니다");
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
				alert.setContentText(array_schedule[j]+"와 "+array_schedule[j-1]+"의 일정이 중첩되었습니다");
				alert.show();
			}
			
			else
			{
				textField.setText("abc");
				textField.clear();
				for(j=0; j<=i; j++)
				{
					textField.appendText("일정 : "+ array_schedule[j] +"	"+ "[" +S_Year[j]+" 년 " + S_Month[j]+" 월 "+S_Day[j]+" 일 " + S_O_clock[j]+" 시 " + S_Min[j]+" 분" + "]" + "\n");
				}
				i++;
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
}
