package com.thatbit.rlsaveeditor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.thatbit.rlsaveeditor.extern.ControlledScreen;
import com.thatbit.rlsaveeditor.extern.ScreensController;

import javafx.fxml.Initializable;

public class CharacterViewController implements Initializable,ControlledScreen{
	
	private ScreensController myController;

	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
