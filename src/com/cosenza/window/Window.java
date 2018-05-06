package com.cosenza.window;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Window extends Application
{

    /*
        README
        You now have a window that has drop down menus with items in it. Giving them funtionality
        is the next step.
        Theres an event handle for the open  menuItem, but apparently theres a better way to do those
        using lambda functions.
        Figure it out.
    */

    private FileChooser fileChooser;
    private Stage stage;
    private BorderPane border;
    private TextArea textArea;
    private Scene scene;
    private MenuBar menuBar;
    public void windowStart(String[] args)
    {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("My first JavaFX app");
        menuInit();

        border = new BorderPane();
        scene = new Scene(border);
        border.setTop(menuBar);

        //Text Area
        textArea = new TextArea();
        border.setCenter(textArea);

        //File Chooser
        stage = new Stage();
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open");


        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    private void menuInit()
    {
        //Menu
        menuBar = new MenuBar();
        //File
        Menu fileMenu = new Menu("File");
        MenuItem open = new MenuItem("Open");

/*
        open.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                System.out.println("Clicked Open");
            }

    });
    */
        open.setOnAction((ActionEvent event) -> {
            fileChooser.showOpenDialog(stage);
            System.out.println("Clicked Open");
        });
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
    }
}
