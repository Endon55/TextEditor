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
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fxmisc.richtext.StyleClassedTextArea;

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
    private Stage stage;
    private BorderPane border;
    private StyleClassedTextArea textArea;
    //TextArea textArea;
    //private TextFlow textFlow;
    private Scene scene;

    //File
    private File file;
    private FileChooser fileChooser;

    //Menus
    private Menus menus;
    private MenuBar menuBar;
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
        textArea = new StyleClassedTextArea();
        menus = new Menus();
        primaryStage.setTitle("Text Editor");
        menuInit();
        fileEventHandler();
        border = new BorderPane();
        scene = new Scene(border, 750  , 500);
        border.setTop(menuBar);

        //Text Area
        //textArea = new TextArea();
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

    private void fileEventHandler()
    {
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
        //Save
        save.setOnAction((ActionEvent event) -> {
            if(file == null)
            {
                file = fileChooser.showSaveDialog(stage);
            }
            saveFile(textArea.getText(), file);
        });
        //Save as
        saveAs.setOnAction((ActionEvent event) -> {
            file = fileChooser.showSaveDialog(stage);
            saveFile(textArea.getText(), file);
        });
        //Exit
        exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
    }

    private void editEventHandler()
    {
        cut.setOnAction((ActionEvent event) -> {


    });
    }

}
