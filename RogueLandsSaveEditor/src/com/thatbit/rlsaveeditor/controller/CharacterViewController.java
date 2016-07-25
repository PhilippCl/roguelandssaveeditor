package com.thatbit.rlsaveeditor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.thatbit.rlsaveeditor.RoguelandsSaveEditor;
import com.thatbit.rlsaveeditor.extern.ControlledScreen;
import com.thatbit.rlsaveeditor.extern.ScreensController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CharacterViewController implements Initializable,ControlledScreen{
	
	@SuppressWarnings("unused")
	private ScreensController myController;
	
	@FXML
	private TextField nameField;
	@FXML
	private ComboBox<String> raceComboBox;
	@FXML
	private Button saveBtn;

	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert nameField != null : "fx:id \"nameField\" was not injected! 'CharacterViewController.fxml'";
		assert raceComboBox != null : "fx:id \"raceComboBox\" was not injected! 'CharacterViewController.fxml'";
		assert saveBtn != null : "fx:id \"saveBtn\" was not injected! 'CharacterViewController.fxml'";
		
		nameField.setText(RoguelandsSaveEditor.sf.getValue(RoguelandsSaveEditor.charNum+"name").toString());
	}

}
