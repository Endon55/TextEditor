package com.cosenza.window;

import javafx.application.Application;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Menus
{

    public Menu fileMenu = new Menu("File");
    public MenuItem open;
    public MenuItem saveAs;
    public MenuItem save;
    public MenuItem exit;
    public MenuBar menuBar;


    Menus()
    {
        System.out.println("Constructor Called");
        menuBar = new MenuBar();
        //fileMenu = new Menu("File");

        open = new MenuItem("Open");
        saveAs = new MenuItem("Save As");
        save = new MenuItem("Save");
        exit = new MenuItem("Exit");

    }


    public Menu getFileMenu()
    {
        System.out.println("getFileMenu called");
        return fileMenu;
    }




}