package com.cosenza;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Window extends Application
{

    private BorderPane border;
    private TextArea textArea;
    private Scene scene;

    public void windowStart(String[] args)
    {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("My first JavaFX app");

        //Menu
        border = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu optionsMenu = new Menu("Options");
        Menu helpMenu = new Menu("Help");
        menuBar.getMenus().addAll(fileMenu, optionsMenu, helpMenu);
        border.setTop(menuBar);

        //Text Area
        textArea = new TextArea();
        border.setCenter(textArea);

        scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
