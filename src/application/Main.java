package application;
	
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	Scene scene1,scene2;
    @Override
    public void start(Stage primaryStage) {
    	String path = "C:/자바 유저"; //폴더 경로
    	File Folder = new File(path);
    	Folder.mkdir();
    	File file = new File("C:/자바 유저/UserID.txt");
    	try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	File file2 = new File("C:/자바 유저/UserIDPW.txt");
    	try {
			file2.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("일정 관리");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
