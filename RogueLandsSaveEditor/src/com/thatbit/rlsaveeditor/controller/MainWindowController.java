package com.thatbit.rlsaveeditor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.thatbit.rlsaveeditor.extern.ControlledScreen;
import com.thatbit.rlsaveeditor.extern.ScreensController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

public class MainWindowController implements Initializable,ControlledScreen {
	
	private ScreensController myController;
	
	@FXML
	private Tab charOneTab;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert charOneTab != null : "fx:id \"charOneTab\" was not injected! 'LangExcerciseView.fxml'";
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;
	}
	
}
