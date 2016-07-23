package com.thatbit.rlsaveeditor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.thatbit.rlsaveeditor.extern.ControlledScreen;
import com.thatbit.rlsaveeditor.extern.ScreensController;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainWindowController implements Initializable,ControlledScreen {
	
	private ScreensController myController;
	
	@FXML
	private Button charOneButton;
	@FXML
	private Button charTwoButton;
	@FXML
	private Button charThreeButton;
	@FXML
	private Button charFourButton;
	@FXML
	private Button charFiveButton;
	@FXML
	private Button charSixButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert charOneButton != null : "fx:id \"charOneButton\" was not injected! 'MainWindow.fxml'";
		assert charTwoButton != null : "fx:id \"charTwoButton\" was not injected! 'MainWindow.fxml'";
		assert charThreeButton != null : "fx:id \"charThreeButton\" was not injected! 'MainWindow.fxml'";
		assert charFourButton != null : "fx:id \"charFourButton\" was not injected! 'MainWindow.fxml'";
		assert charFiveButton != null : "fx:id \"charFiveButton\" was not injected! 'MainWindow.fxml'";
		assert charSixButton != null : "fx:id \"charSixButton\" was not injected! 'MainWindow.fxml'";
		
		charOneButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				myController.setScreen(TitleBar.characterViewID);
			}
		});
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;
	}
	
}
