package com.cosenza;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

        TextArea textArea = new TextArea();
        VBox vbox = new VBox(textArea);
        Scene scene = new Scene(vbox, 200, 100);

        textArea.setMaxSize(5000,1000000);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
