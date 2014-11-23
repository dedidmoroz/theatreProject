package com.project.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.spring.config.AppConfig;
import com.project.spring.config.ScreenConfig;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Platform.setImplicitExit(true);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ScreenConfig screenConfig = context.getBean(ScreenConfig.class);
		
		screenConfig.setStage(primaryStage);
		screenConfig.showMainPane();
		screenConfig.loadMainPresentation();
		
	}
	
	 
}
