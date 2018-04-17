package com.cosenza;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Window extends Application
{

    public void windowStart()
    {
        Application.launch();
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
