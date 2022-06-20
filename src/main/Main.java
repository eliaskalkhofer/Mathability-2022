package main;

import helper.Gamemode;
import helper.Highscores;
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
        Highscores.getInstance().restore();
     CTitlescreen.show(primaryStage);
    }

    public void stop(){
        Highscores.getInstance().store();
        System.exit(1);

    }
}