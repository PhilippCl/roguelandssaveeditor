package com.thatbit.rlsaveeditor;

import java.io.File;
import java.io.IOException;

import com.thatbit.rlsaveeditor.data.Savefile;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RoguelandsSaveEditor extends Application{

	private String version = "0.1";

	//Only for testing ... not final 
	public static Savefile sf;


	public RoguelandsSaveEditor(){
	}

	public void init(File file){
		this.sf = new Savefile();
		try {
			this.sf.readFile(file.getAbsolutePath());
			this.sf.parseData();
		} catch (IOException e) {
			Alert errorInfo = new Alert(AlertType.ERROR);
			errorInfo.setHeaderText("Invalid File");
			errorInfo.setContentText("The File you selected is no valid File. Canceling");
			errorInfo.showAndWait();
			Platform.exit();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//User information
		Alert userInfo = new Alert(AlertType.INFORMATION);
		userInfo.setHeaderText("Information");
		userInfo.setContentText("Please choose the File you want to edit. The default Savefile is located "
				+"at:\n C:\\Users\\'Username'\\AppData\\LocalLow\\DefaultCompany\\Roguelands");
		userInfo.showAndWait();

		//FileChooser
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open PlayerPrefs File");
		File playerPrefsFile = fileChooser.showOpenDialog(primaryStage);
		if(playerPrefsFile != null){
			init(playerPrefsFile);

			//UI Init
			primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/icon.png")));
			Parent root = FXMLLoader.load(getClass().getResource("gui/view/TitleBar.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setMinWidth(500);
			primaryStage.setMinHeight(400);
			primaryStage.setTitle("Roguelands Save Editor " + version);
			primaryStage.show();
		}else{
			Alert errorInfo = new Alert(AlertType.ERROR);
			errorInfo.setHeaderText("Invalid File");
			errorInfo.setContentText("The File you selected is no valid File. Canceling");
			errorInfo.showAndWait();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
