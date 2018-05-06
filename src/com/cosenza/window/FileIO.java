package com.cosenza.window;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileIO
{
    //private FileChooser fileChooser;
    //private Stage stage = new Stage();

    public void open(FileChooser fileChooser, Stage stage)
    {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open");
        fileChooser.showOpenDialog(stage);
    }


}
