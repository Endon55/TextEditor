package com.cosenza.window;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.GenericStyledArea;
import org.fxmisc.richtext.StyleClassedTextArea;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import java.awt.*;


public class Testbench extends Application
{

    private StyleClassedTextArea area;
    private Menus menus;

    private FileChooser fileChooser;
    private Stage stage;
    private BorderPane border;
    TextArea textArea;
    private TextFlow textFlow;
    private Scene scene;
    private MenuBar menuBar;
    private File file;

    //Menus
    //File
    private Menu fileMenu;
    private MenuItem open;
    private MenuItem saveAs;
    private MenuItem save;
    private MenuItem exit;
    //Edit
    private Menu editMenu;
    private MenuItem cut;
    private MenuItem copy;
    private MenuItem paste;
    //Format
    private Menu formatMenu;
    private MenuItem size;
    private MenuItem font;
    private MenuItem color;
    //Help
    private Menu helpMenu;
    private MenuItem version;


    public void windowStart(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Text Editor");
        menuInit();
        //eventHandler();
        area = new StyleClassedTextArea();
        area.setWrapText(true);
        VirtualizedScrollPane<StyleClassedTextArea> vsPane = new VirtualizedScrollPane<>(area);
        Text text = new Text("Hello");
        textFlow = new TextFlow(text);
        border = new BorderPane();
        scene = new Scene(border, 500, 500);
        border.setTop(menuBar);
        border.setCenter(area);


        //Text Area
        //textArea = new TextArea();
        //textArea.setWrapText(true);
        //border.setCenter(textFlow);



        //File Chooser
        stage = new Stage();


        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    private void menuInit()
    {
        //Menu
        menuBar = new MenuBar();
        //File
        fileMenu = new Menu("File");
        open = new MenuItem("Open");
        saveAs = new MenuItem("Save As");
        save = new MenuItem("Save");
        exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(open, save, saveAs, exit);
        //Edit
        editMenu = new Menu("Edit");
        cut = new MenuItem("Cut");
        copy = new MenuItem("Copy");
        paste = new MenuItem("Paste");
        editMenu.getItems().addAll(cut, copy, paste);
        //Format
        formatMenu = new Menu("Format");
        size = new MenuItem("Size");
        font = new MenuItem("Font");
        color = new MenuItem("Color");
        formatMenu.getItems().addAll(size, font, color);
        //Help
        helpMenu = new Menu("Help");
        version = new MenuItem("Version");
        helpMenu.getItems().addAll(version);

        menuBar.getMenus().addAll(fileMenu, editMenu, formatMenu, helpMenu);
    }

}
