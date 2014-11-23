package com.project.main.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.dialog.Dialogs;
import org.springframework.beans.factory.annotation.Autowired;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.Duration;

import com.project.hibernate.dao.DAO;
import com.project.hibernate.entity.Acthors;
import com.project.hibernate.entity.Employments;
import com.project.hibernate.entity.Spectacles;
import com.project.hibernate.service.Service;
import com.project.main.Presentation;
import com.project.spring.config.ScreenConfig;
import com.project.tableview.numerics.NumericEditableTableCell;

public class FXMLMainPresentation extends Presentation{

	@Autowired(required=true)
	private Service service;
	//Table references
	@FXML
    private TableView<Acthors> tabActhors;

    @FXML
    private TableView<Spectacles> tabSpectacles;
    
    @FXML
    private TableView<Employments> tabEmployments;
    
    
    //Columns references	   
	@FXML
    private TableColumn specId;

    @FXML
    private TableColumn empId;


    @FXML
    private TableColumn specDate;

    @FXML
    private TableColumn acthName;

    @FXML
    private TableColumn empSpecId;

    

    @FXML
    private TableColumn acthSurname;

    @FXML
    private TableColumn specName;

    @FXML
    private TableColumn specBougette;


    @FXML
    private TableColumn acthAge;

    @FXML
    private TableColumn acthAppoint;

    @FXML
    private TableColumn empActhId;

    @FXML
    private TableColumn empRole;

    @FXML
    private TableColumn acthCarrer;

    @FXML
    private TableColumn empContractYear;

    @FXML
    private TableColumn acthId;

    
    @FXML
    private Accordion mainAccordation;
	 
	public FXMLMainPresentation(ScreenConfig screenConfig) {
		super(screenConfig);
	}

	@FXML
	public void click(ActionEvent e){}
	  
	@FXML
	void initialize() {
		
		this.tabActhors.setEditable(true);
		this.tabEmployments.setEditable(true);
		this.tabSpectacles.setEditable(true);
		
		 this.initializeTableActhorses();
		 this.initializeTableSpectacles();
		 this.initializeTableEmployments();
	}

	
	 	@FXML
	    void closeProject(ActionEvent event) {
		 	System.exit(0);
	    }
	
	Callback<TableColumn,TableCell> numeric = arg0 -> new NumericEditableTableCell();
	
	
	@SuppressWarnings("unchecked")
	public void initializeTableActhorses(){
		acthId.setCellValueFactory(new PropertyValueFactory("id"));
		
		acthName.setCellValueFactory(new PropertyValueFactory("name"));
		acthName.setCellFactory(TextFieldTableCell.forTableColumn());
		acthName.setOnEditCommit(new EventHandler<CellEditEvent<Acthors, String>>() {
			@Override
			public void handle(CellEditEvent<Acthors, String> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
			}
		});
		
		acthSurname.setCellValueFactory(new PropertyValueFactory("surname"));
		acthSurname.setCellFactory(TextFieldTableCell.forTableColumn());
		acthSurname.setOnEditCommit(new EventHandler<CellEditEvent<Acthors, String>>() {
			@Override
			public void handle(CellEditEvent<Acthors, String> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setSurname(event.getNewValue());
			}
		});
		
		acthAge.setCellValueFactory(new PropertyValueFactory("age"));
		acthAge.setCellFactory(numeric);
		acthAge.setOnEditCommit(new EventHandler<CellEditEvent<Acthors, Long>>() {
			@Override
			public void handle(CellEditEvent<Acthors, Long> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setAge(event.getNewValue());
			}
		});
		 
	
		acthAppoint.setCellValueFactory(new PropertyValueFactory("appointment"));
		acthAppoint.setCellFactory(TextFieldTableCell.forTableColumn());
		acthAppoint.setOnEditCommit(new EventHandler<CellEditEvent<Acthors, String>>() {
			@Override
			public void handle(CellEditEvent<Acthors, String> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setAppointment(event.getNewValue());
			}
		});
		
		
		acthCarrer.setCellValueFactory(new PropertyValueFactory("carrer"));
		acthCarrer.setCellFactory(numeric); 
		acthCarrer.setOnEditCommit(new EventHandler<CellEditEvent<Acthors, Long>>() {
			@Override
			public void handle(CellEditEvent<Acthors, Long> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setCarrer(event.getNewValue());
			}
		});
		
		
		tabActhors.setItems(FXCollections.observableArrayList(service.getAll(Acthors.class)));
		
	}
	
	@SuppressWarnings("unchecked")
	public void initializeTableSpectacles(){
		specId.setCellValueFactory(new PropertyValueFactory<Spectacles,Long>("id"));
		
		specName.setCellValueFactory(new PropertyValueFactory<Spectacles, String>("name"));
		specName.setCellFactory(TextFieldTableCell.forTableColumn());
		specName.setOnEditCommit(new EventHandler<CellEditEvent<Spectacles,String>>() {
			@Override
			public void handle(CellEditEvent<Spectacles, String> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
			}
		});
		
		specBougette.setCellValueFactory(new PropertyValueFactory<Spectacles, Long>("bougette"));
		specBougette.setCellFactory(numeric);
		specBougette.setOnEditCommit(new EventHandler<CellEditEvent<Spectacles,Long>>() {
			@Override
			public void handle(CellEditEvent<Spectacles, Long> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setBougette(event.getNewValue());
			}
		});
		
		specDate.setCellValueFactory(new PropertyValueFactory("year"));
		specDate.setCellFactory(numeric);
		specDate.setOnEditCommit(new EventHandler<CellEditEvent<Spectacles,Long>>() {
			@Override
			public void handle(CellEditEvent<Spectacles, Long> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setYear(event.getNewValue());
			}
		});
		
		tabSpectacles.setItems(FXCollections.observableArrayList(service.getAll(Spectacles.class)));
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public void initializeTableEmployments() {
		empId.setCellValueFactory(new PropertyValueFactory("id"));
		
		empRole.setCellValueFactory(new PropertyValueFactory("role"));
		empRole.setCellFactory(TextFieldTableCell.forTableColumn());
		empRole.setOnEditCommit(new EventHandler<CellEditEvent<Employments,String>>() {
			@Override
			public void handle(CellEditEvent<Employments, String> arg0) {
				arg0.getTableView().getItems().get(arg0.getTablePosition().getRow()).setRole(arg0.getNewValue());
			}
		});
		
		empContractYear.setCellValueFactory(new PropertyValueFactory("year_contract"));
		empContractYear.setCellFactory(numeric);
		empContractYear.setOnEditCommit(new EventHandler<CellEditEvent<Employments,Long>>() {
			@Override
			public void handle(CellEditEvent<Employments, Long> arg0) {
				arg0.getTableView().getItems().get(arg0.getTablePosition().getRow()).setYear_contract(arg0.getNewValue());
			}
		});
	
		
		
		
		List<Acthors> lstActhors = (List<Acthors>) service.getAll(Acthors.class);
		ObservableList<String> obsList1 = FXCollections.observableArrayList();
		ObservableList<String> obsList2 = FXCollections.observableArrayList();
		
		for(Acthors i:lstActhors)
			obsList1.add(i.getName());
			
		empActhId.setCellValueFactory(new PropertyValueFactory("act"));
		empActhId.setCellFactory(ComboBoxTableCell.forTableColumn(obsList1));
		empActhId.setOnEditCommit(new EventHandler<CellEditEvent<Employments,String>>() {
			@Override
			public void handle(CellEditEvent<Employments, String> arg0) {
				String actName = arg0.getNewValue();
				Acthors act = (Acthors) service.makeQuery("SELECT * FROM acthors where NAME = '"+actName+"'",Acthors.class).get(0);
				arg0.getTableView().getItems().get(arg0.getTablePosition().getRow()).setAchtor(act);
				arg0.getTableView().getItems().get(arg0.getTablePosition().getRow()).setAct(actName);;
			}
		});
		
		 
		List<Spectacles> lstSpec = (List<Spectacles>)service.getAll(Spectacles.class);
		
		for(Spectacles i:lstSpec)
			obsList2.add(i.getName());
		
		empSpecId.setCellValueFactory(new PropertyValueFactory("spec"));
		empSpecId.setCellFactory(ComboBoxTableCell.forTableColumn(obsList2));
		empSpecId.setOnEditCommit(new EventHandler<CellEditEvent<Employments,String>>() {
			@Override
			public void handle(CellEditEvent<Employments, String> arg0) {
				String specName = arg0.getNewValue();
				Spectacles spec = (Spectacles) service.makeQuery("SELECT * from spectacles where NAME = '"+specName+"'",Spectacles.class).get(0);
				arg0.getTableView().getItems().get(arg0.getTablePosition().getRow()).setSpectacle(spec);
				arg0.getTableView().getItems().get(arg0.getTablePosition().getRow()).setSpec(specName); 
			}
		});
		
		List<Employments> lstAll =(List<Employments>) service.getAll(Employments.class);
		for(Employments i:lstAll){
			i.setAct(i.getAchtor().getName());
			i.setSpec(i.getSpectacle().getName());
		}
		
		tabEmployments.setItems(FXCollections.observableArrayList(lstAll));
	}
	
	
	
}
 