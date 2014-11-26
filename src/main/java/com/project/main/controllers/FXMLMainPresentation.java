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
import javafx.scene.control.TitledPane;
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
	 
    @FXML
    private TitledPane actAcor;
    
    @FXML
    private TitledPane emplAcor;
    
    @FXML
    private TitledPane specAcor;
	
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
			obsList1.add(i.getSurname());
			
		empActhId.setCellValueFactory(new PropertyValueFactory("act"));
		empActhId.setCellFactory(ComboBoxTableCell.forTableColumn(obsList1));
		empActhId.setOnEditCommit(new EventHandler<CellEditEvent<Employments,String>>() {
			@Override
			public void handle(CellEditEvent<Employments, String> arg0) {
				String actName = arg0.getNewValue();
				Acthors act = (Acthors) service.makeQuery("SELECT * FROM acthors where SURNAME = '"+actName+"'",Acthors.class).get(0);
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
	
	@FXML
    void clickSave(ActionEvent event) {
		if(actAcor.isExpanded()){
			ObservableList<Acthors> acthorsList = tabActhors.getItems();
			for(Acthors i:acthorsList){
				service.update(i, Acthors.class);
			}
			Dialogs.create().masthead("Повідомлення про стан операції").message("Збережено зміни!").
			title("Повідомлення").showInformation();
		}
		if(specAcor.isExpanded()){
			ObservableList<Spectacles> specList = tabSpectacles.getItems();
			for(Spectacles i:specList){
				service.update(i, Spectacles.class);
			}
			Dialogs.create().masthead("Повідомлення про стан операції").message("Збережено зміни!").
			title("Повідомлення").showInformation();
		}
		if(emplAcor.isExpanded()){
			ObservableList<Employments> emplList = tabEmployments.getItems();
			for(Employments i:emplList){
				service.update(i, Employments.class);
			}
			
			Dialogs.create().masthead("Повідомлення про стан операції").message("Збережено зміни!").
			title("Повідомлення").showInformation();
		}
		
    }
	 @SuppressWarnings("unchecked")
	public void refresh(){
    	this.tabActhors.getItems().clear();
		 this.tabEmployments.getItems().clear();
		 this.tabSpectacles.getItems().clear();
		 
		 tabActhors.setItems(FXCollections.observableArrayList(service.getAll(Acthors.class)));
		 tabSpectacles.setItems(FXCollections.observableArrayList(service.getAll(Spectacles.class)));
		 
		 List<Employments> lstAll =(List<Employments>) service.getAll(Employments.class);
			for(Employments i:lstAll){
				i.setAct(i.getAchtor().getName());
				i.setSpec(i.getSpectacle().getName());
			}
		 tabEmployments.setItems(FXCollections.observableArrayList(lstAll));
    }
	
   
	@FXML
	 void clickRefresh(ActionEvent event) {
		 this.refresh();
	 }
    
    
    
    @SuppressWarnings({ "unchecked", "deprecation" })
	@FXML
    void clickNewRecord(ActionEvent event) {
    	if(actAcor.isExpanded()){
    		
    		Acthors newActhor = new Acthors();
    		newActhor.setName(" ");
    		newActhor.setSurname(" ");
    		newActhor.setAge(Long.valueOf("0"));
    		newActhor.setCarrer(Long.valueOf("0"));
    		newActhor.setAppointment(" ");
    		service.save(newActhor, Acthors.class);
    		
    		this.tabActhors.getItems().clear();
    		tabActhors.setItems(FXCollections.observableArrayList(service.getAll(Acthors.class)));
    		Dialogs.create().masthead("Повідомлення про стан операції").message("Додано запис").
				title("Повідомлення").showInformation();
    	}
		if(specAcor.isExpanded()){
			Spectacles newSpectacle = new Spectacles();
			newSpectacle.setName(" ");
			newSpectacle.setBougette(Long.valueOf(0));
			newSpectacle.setYear(Long.valueOf("2000"));
			service.save(newSpectacle, Spectacles.class);
			
			this.tabSpectacles.getItems().clear();
		    tabSpectacles.setItems(FXCollections.observableArrayList(service.getAll(Spectacles.class)));
		    Dialogs.create().masthead("Повідомлення про стан операції").message("Додано запис").
				title("Повідомлення").showInformation();
		}
		if(emplAcor.isExpanded()){
			Employments empl = new Employments();
			
			empl.setRole(" ");
			empl.setYear_contract(Long.valueOf("2000"));
	
			empl.setSpectacle(null);
			empl.setAchtor(null);
			
			Acthors act = (Acthors) service.makeQuery("SELECT * FROM acthors WHERE ID=1", Acthors.class).get(0);
			Spectacles spec = (Spectacles) service.makeQuery("SELECT * FROM spectacles WHERE ID=1", Spectacles.class).get(0);
			if(spec!=null && act!=null){
				empl.setSpectacle(spec);
				empl.setAchtor(act);
				service.save(empl, Employments.class);
				this.tabEmployments.getItems().clear();
				
				//refresh don't touch 
				List<Employments> lstAll =(List<Employments>) service.getAll(Employments.class);
				for(Employments i:lstAll){
					i.setAct(i.getAchtor().getName());
					i.setSpec(i.getSpectacle().getName());
				}
				tabEmployments.setItems(FXCollections.observableArrayList(lstAll));
				Dialogs.create().masthead("Повідомлення про стан операції").message("Додано запис").
					title("Повідомлення").showInformation();
			} else {
				Dialogs.create().masthead("Повідомлення про стан операції").message("Поимилка").
				title("Повідомлення").showError();
				
			}
		}
    }

    @SuppressWarnings("deprecation")
	@FXML
    void clickDeleteRecord(ActionEvent event) {
    	if(actAcor.isExpanded()){
			if(tabActhors.getSelectionModel().getSelectedIndex()!=-1){
				Acthors actor = tabActhors.getSelectionModel().getSelectedItem();
				List<Employments> lst = service.makeQuery("SELECT * FROM employments WHERE A_ID = "+actor.getId(), Employments.class);
				if(lst.size()!=0){
					Dialogs.create().masthead("Видаліть спершу всі записи таблиці 'Зайнятість', які ссилаються на даний запис").message("Видалено!").
					title("Повідомлення")
						.showError();
				}else{
					service.delete(actor, actor.getId(), Acthors.class);
					this.refresh();
					Dialogs.create().masthead("Повідомлення про стан операції").message("Видалено!").
						title("Повідомлення")
							.showInformation();
				}	
				
			}
			
		}
		if(specAcor.isExpanded()){
			
			
			if(tabSpectacles.getSelectionModel().getSelectedIndex()!=-1){
				Spectacles spectacle = tabSpectacles.getSelectionModel().getSelectedItem();
				List<Employments> lst = service.makeQuery("SELECT * FROM employments WHERE S_ID = "+spectacle.getId(), Employments.class);
				if(lst.size()!= 0){
					Dialogs.create().masthead("Повідомлення про стан операції")
					.message("Видаліть спершу всі записи таблиці 'Зайнятість', які ссилаються на даний запис")
						.title("Повідомлення")
							.showError();
				}else {
					service.delete(spectacle, spectacle.getId(), Spectacles.class);
					Dialogs.create().masthead("Повідомлення про стан операції").message("Видалено!").
					title("Повідомлення")
						.showInformation();
					this.refresh();
				}
			}
			
		}
		if(emplAcor.isExpanded()){
			if(tabEmployments.getSelectionModel().getSelectedIndex()!=-1){
				Employments empl = tabEmployments.getSelectionModel().getSelectedItem();
				service.delete(empl, empl.getId(), Employments.class);
			}
			Dialogs.create().masthead("Повідомлення про стан операції").message("Видалено!").
				title("Повідомлення")
				.showInformation();
			this.refresh();
		}
    }
	
}
 