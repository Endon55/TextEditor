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

import java.awt.*;
import java.io.*;
import java.util.Scanner;

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
    //probably not needed
    private Desktop desktop;

    //Init
    private FileIO fio;

    private FileChooser fileChooser;
    private Stage stage;
    private BorderPane border;
    private TextArea textArea;
    private Scene scene;
    private MenuBar menuBar;
    private File file;
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

        textArea.setWrapText(true);
        border.setCenter(textArea);

        //File Chooser
        stage = new Stage();
        fileChooser = new FileChooser();
        desktop = Desktop.getDesktop();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);


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

        //Open
        open.setOnAction((ActionEvent event) -> {
            System.out.println("Clicked Open");
            //fio.open(fileChooser, stage);
            fileChooser.setTitle("Open");
            file = fileChooser.showOpenDialog(stage);
            if(file != null)
            {
                openFile(file);
            }
        });

        //Save as
        MenuItem saveAs = new MenuItem("Save As");
        saveAs.setOnAction((ActionEvent event) -> {
            file = fileChooser.showSaveDialog(stage);
            saveFile(textArea.getText(), file);
        });
        //Save
        MenuItem save = new MenuItem("Save");
        save.setOnAction((ActionEvent event) -> {
            if(file == null)
            {
                file = fileChooser.showSaveDialog(stage);
            }
            saveFile(textArea.getText(), file);
        });

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


    private void openFile(File file)
    {

        try
        {
            Scanner s = new Scanner(file).useDelimiter("\\s+");
            String line;
            while(s.hasNext())
            {
                line = s.nextLine();
                System.out.println(line);
                textArea.appendText(line);
                if(s.hasNext())
                {
                    textArea.appendText("\n");
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.print("Could't open file");
            e.printStackTrace();
        }

    }

    private void saveFile(String text, File file)
    {

        try
        {
            if(file != null)
            {
                FileWriter fileWriter;
                fileWriter = new FileWriter(file);
                fileWriter.write(text);
                fileWriter.close();
            }
        } catch (IOException e)
        {
            System.out.println("Couldnt close File");
        }
    }

}
