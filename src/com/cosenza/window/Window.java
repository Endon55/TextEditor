package com.cosenza.window;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.StyleClassedTextArea;
import org.fxmisc.richtext.StyledTextArea;

import javax.tools.Tool;
import java.awt.datatransfer.Transferable;
import java.io.*;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;


public class Window extends Application
{

    /*
        README
        This project is currently benched.
        The concepts in the RichTextFX library are too complicated for me at the moment.
    */
    //probably not needed
    //private Desktop desktop;

    CustomObject co = new CustomObject(true, true, 0, "");

    //Init
    private Stage stage;
    private BorderPane border;
    //private CodeArea textArea;
    private StyleClassedTextArea textArea;

    //TextArea textArea;
    //private TextFlow textFlow;
    List<String> styleClasses = Arrays.asList("-fx-font-color: red", "text-with-caret");
    private Scene scene;

    //File Handling
    private File file;
    private FileChooser fileChooser;

    //Text Formatting



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
        //textArea = new CodeArea();
        //Line Numbers
        textArea.setParagraphGraphicFactory(LineNumberFactory.get(textArea));
        textArea.setStyle("-fx-font-bold;");
        menus = new Menus();
        primaryStage.setTitle("Text Editor");
        menuInit();
        fileEventHandler();
        editEventHandler();
        formatEventHandler();
        border = new BorderPane();
        scene = new Scene(border, 750, 500);
        border.setTop(menuBar);

        //Text Area
        //textArea = new TextArea();
        textArea.setWrapText(true);
        border.setCenter(textArea);


        IndexRange selection = textArea.getSelection();
        textArea.setStyle(selection.getStart(), selection.getEnd(), co.toList());

        //File Chooser
        stage = new Stage();
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
        textArea.setStyle("");
       // textArea.setStyleClass(selection.getStart(), selection.getEnd(), styleClasses);
        //textArea.getStyleClass();


        Text caption = new Text("Hello World!");
        applyStyle(caption, co);

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
        //TODO doesnt clear screen when new file is loaded, it just adds the text to the current text.
        //Open
        open.setOnAction((event) -> {
            fileChooser.setTitle("Open");
            file = fileChooser.showOpenDialog(stage);
            if(file != null)
            {
                openFile(file);
            }
        });
        //Save
        save.setOnAction((event) -> {
            if(file == null)
            {
                file = fileChooser.showSaveDialog(stage);
            }
            saveFile(textArea.getText(), file);
        });
        //Save as
        saveAs.setOnAction((event) -> {
            file = fileChooser.showSaveDialog(stage);
            saveFile(textArea.getText(), file);
        });
        //Exit
        exit.setOnAction((event) -> {
            Platform.exit();
        });
    }

    private void editEventHandler()
    {
        cut.setOnAction((event)  -> { textArea.cut();});
        copy.setOnAction((event) -> { textArea.copy(); });
        paste.setOnAction((event -> { textArea.paste(); }));
    }
    private void formatEventHandler()
    {
        size.setOnAction((event) -> {
            /*

            textArea.getStyleClass().add(selection.getStart(), selection.getEnd(), "-fx-font-family: Helvetica");
            //textArea.setStyle(selection.getStart(), selection.getEnd(), ");
            //caption.setFill();
            //caption.setStyle();

            textArea.setStyle("-fx-font-size: 1em;");
            //scene.add(caption);
            */


            co.toList();

        });
    }

}


