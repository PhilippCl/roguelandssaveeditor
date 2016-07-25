package com.thatbit.rlsaveeditor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.thatbit.rlsaveeditor.RoguelandsSaveEditor;
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

		//Disable Buttons if char does not exists
		if(!RoguelandsSaveEditor.sf.hasValue("0name")){
			charOneButton.setDisable(true);
		}
		if(!RoguelandsSaveEditor.sf.hasValue("1name")){
			charTwoButton.setDisable(true);
		}
		if(!RoguelandsSaveEditor.sf.hasValue("2name")){
			charThreeButton.setDisable(true);
		}
		if(!RoguelandsSaveEditor.sf.hasValue("3name")){
			charFourButton.setDisable(true);
		}
		if(!RoguelandsSaveEditor.sf.hasValue("4name")){
			charFiveButton.setDisable(true);
		}
		if(!RoguelandsSaveEditor.sf.hasValue("5name")){
			charSixButton.setDisable(true);
		}

		charOneButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				RoguelandsSaveEditor.charNum = 0;
				myController.setScreen(TitleBar.characterViewID);
			}
		});
		charTwoButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				RoguelandsSaveEditor.charNum = 1;
				myController.setScreen(TitleBar.characterViewID);
			}
		});
		charThreeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				RoguelandsSaveEditor.charNum = 2;
				myController.setScreen(TitleBar.characterViewID);
			}
		});
		charFourButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				RoguelandsSaveEditor.charNum = 3;
				myController.setScreen(TitleBar.characterViewID);
			}
		});
		charFiveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				RoguelandsSaveEditor.charNum = 4;
				myController.setScreen(TitleBar.characterViewID);
			}
		});
		charSixButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				RoguelandsSaveEditor.charNum = 5;
				myController.setScreen(TitleBar.characterViewID);
			}
		});
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;
	}

}
