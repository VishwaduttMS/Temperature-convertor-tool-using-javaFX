package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    public static void main(String[] args){
        System.out.println("main");
        launch(args);

    }

    @Override
    public void init() throws Exception {
        System.out.println("init"); // Initialize your application
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");    // Starts an application

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temp. Convertor");
        primaryStage.show();
    }

    private MenuBar createMenu()
    {
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("Clicked"));
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);


        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        aboutApp.setOnAction(event -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("My first desktop app");
        alert.setHeaderText("Learning JavaFX");
        alert.setContentText("I will develop super cool stuffs");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alert.getButtonTypes().setAll(yesBtn, noBtn);
        Optional<ButtonType> clickedBtn = alert.showAndWait();

        if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn)
        {
            System.out.println("Yes");
        }
        if(clickedBtn.isPresent() && clickedBtn.get() == noBtn)
        {
            System.out.println("No");
        }
    }

    @Override
    public void stop() throws Exception {

        System.out.println("stop"); // Called when application is stopped and is about to shut down
        super.stop();
    }
}
