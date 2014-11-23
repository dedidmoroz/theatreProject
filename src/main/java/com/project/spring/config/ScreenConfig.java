package com.project.spring.config;

import java.io.IOException;
import java.net.URL;
import java.util.Observer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.project.main.Presentation;
import com.project.main.controllers.FXMLMainPresentation;

import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

@Configuration
@Lazy
public class ScreenConfig implements Observer{

	private Stage stage;
	private Scene scene;
	private StackPane node;
	private Double STAGE_SIZE_H = Double.valueOf("651");
	private Double STAGE_SIZE_V = Double.valueOf("460");
	
	public Stage getStage() {
		return stage;
	}

	
	public void setStage(Stage stage) {
		this.stage = stage;
	}


    public void showMainPane(){
    	node = new StackPane();
    	scene = new Scene(node);
    	scene.getStylesheets().add("/css/style.css");
    	stage.setScene(scene);
    	stage.setOnCloseRequest(e->{
    		System.exit(0);
    		
    	});
    	this.stage.setMaxHeight(this.STAGE_SIZE_V);
    	this.stage.setMaxWidth(this.STAGE_SIZE_H);
    	
    	this.stage.show();
    }
    
    public void setNode(Node node){
    	this.node.getChildren().add(node);
    }

    
    @Bean
    @Scope("prototype")
    public FXMLMainPresentation mainPresantation(){
    	return new FXMLMainPresentation(this);
    }
    
    
    public Node getNode(final Presentation controller,URL resource){
    	FXMLLoader loader = new FXMLLoader(resource);
    	loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> arg0) {
				// TODO Auto-generated method stub
				return controller;
			}
		});
    	try {
			return (Node) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
    
   
    public void loadMainPresentation(){
    	Node node = getNode(mainPresantation(), getClass().getResource("/mainScene.fxml"));
    	this.setNode(node);
    	
    	System.out.println("load");
    }
    
	@Override
	public void update(java.util.Observable arg0, Object arg1) {
		this.loadMainPresentation();
	}

}
