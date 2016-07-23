package com.thatbit.rlsaveeditor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.thatbit.rlsaveeditor.extern.ScreensController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

public class TitleBar implements Initializable{

	//Different Menues
	public static String mainWindowID = "mainWindow";
	public static String mainWindowFile = "gui/view/MainWindow.fxml";

	public static String characterViewID = "characterView";
	public static String characterViewFile = "gui/view/CharacterView.fxml";

	@FXML
	private StackPane containerPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assert containerPane != null : "fx:id \"containerPane\" was not injected! 'TitleBar.fxml'";
		
		ScreensController con = new ScreensController();
		con.loadScreen(TitleBar.mainWindowID, TitleBar.mainWindowFile);
		con.loadScreen(TitleBar.characterViewID, TitleBar.characterViewFile);
		con.setScreen(TitleBar.mainWindowID);
		
		this.containerPane.getChildren().add(con);
	}

}