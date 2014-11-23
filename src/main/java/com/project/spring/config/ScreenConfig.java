package com.project.spring.config;

import java.io.IOException;
import java.net.URL;
import java.util.Observer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.project.main.Presentation;
import com.project.main.controllers.FXMLMainPresantation;

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
    	this.getStage().show();
    }
    
    public void setNode(Node node){
    	this.node.getChildren().setAll(node);
    }

    public Node getNode(final Presentation controller,URL resource){
    	FXMLLoader loader = new FXMLLoader(resource);
    	loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> arg0) {
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
    
    
    @Bean
    @Scope("prototype")
    public FXMLMainPresantation mainPresantation(){
    	return new FXMLMainPresantation(this);
    }
    
    public void loadMainPresentation(){
    	this.setNode(getNode(mainPresantation(), getClass().getResource("/scenes/mainScene.fxml")));
    	System.out.println("load");
    }
    
	@Override
	public void update(java.util.Observable arg0, Object arg1) {
		this.loadMainPresentation();
	}

}
