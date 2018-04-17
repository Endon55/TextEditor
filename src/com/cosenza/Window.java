package com.cosenza;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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

        border = new BorderPane();
        scene = new Scene(border);

        //Menu
        MenuBar menuBar = new MenuBar();
            //File
        Menu fileMenu = new Menu("File");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem saveAs = new MenuItem("Save As");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(open, save, saveAs, exit);
            //Edit
        Menu editMenu = new Menu("Edit");
        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");
        editMenu.getItems().addAll(cut, copy, paste);
            //Format
        Menu formatMenu = new Menu("Format");
        MenuItem size = new MenuItem("Size");
        MenuItem font = new MenuItem("Font");
        MenuItem color = new MenuItem("Color");
        formatMenu.getItems().addAll(size, font, color);
            //Help
        Menu helpMenu = new Menu("Help");
        MenuItem version = new MenuItem("Version");
        helpMenu.getItems().addAll(version);


        menuBar.getMenus().addAll(fileMenu, editMenu, formatMenu, helpMenu);
        border.setTop(menuBar);

        //Text Area
        textArea = new TextArea();
        border.setCenter(textArea);

        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
