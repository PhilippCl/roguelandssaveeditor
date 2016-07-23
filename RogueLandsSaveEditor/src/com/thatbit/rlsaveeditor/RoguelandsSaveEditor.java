package com.thatbit.rlsaveeditor;

import java.io.IOException;

import com.thatbit.rlsaveeditor.data.Savefile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RoguelandsSaveEditor extends Application{

	private String version = "0.1";
	
	//Only for testing
	private Savefile sf;
	
	
	public RoguelandsSaveEditor(){
	}
	
	public void init(){
		this.sf = new Savefile();
		try {
			this.sf.readFile("PlayerPrefs.txt");
			this.sf.parseData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/icon.png")));
		Parent root = FXMLLoader.load(getClass().getResource("gui/view/TitleBar.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Roguelands Save Editor");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
