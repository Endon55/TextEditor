package com.cosenza;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
    The goal of this project is to build a basic text editor.
    Features I would like to add, Open, Save, Save As, Fonts, Size, Colors..........
 */
public class Main extends Application
{

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("My first JavaFX app");
        BorderPane border = new BorderPane();
        TextArea textArea = new TextArea();
        TextField textField = new TextField();
        Scene scene = new Scene(border);

        border.setCenter(textArea);

        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }


}
