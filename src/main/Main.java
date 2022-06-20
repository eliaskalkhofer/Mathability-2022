package main;

import helper.Gamemode;
import javafx.application.Application;
import javafx.stage.Stage;
import maingamescreen.CGamescreen;
import titlescreen.CTitlescreen;

public class Main extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
     CTitlescreen.show(primaryStage);
    }

    public void stop(){
        System.exit(1);

    }
}