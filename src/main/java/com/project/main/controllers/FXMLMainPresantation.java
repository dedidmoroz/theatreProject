package com.project.main.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.dialog.Dialogs;
import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import com.project.hibernate.dao.DAO;
import com.project.hibernate.entity.Acthors;
import com.project.hibernate.service.Service;
import com.project.main.Presentation;
import com.project.spring.config.ScreenConfig;

public class FXMLMainPresantation extends Presentation{

	@Autowired
	private Service service;
	
	
	@FXML
	private Button connect;
	public FXMLMainPresantation(ScreenConfig screenConfig) {
		super(screenConfig);
	}

	@FXML
	public void click(ActionEvent e){}
	  
	@FXML
	void initialize() {
	
	}

	
	 
	
}
