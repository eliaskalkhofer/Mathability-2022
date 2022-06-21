package main;

import helper.Gamemode;
import helper.Highscores;
import javafx.application.Application;
import javafx.stage.Stage;
import login.Clogin;
import maingamescreen.CGamescreen;
import titlescreen.CTitlescreen;

public class Main extends Application {
    public static void main(String[] args) {
        //standart javafx
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Highscores herreinladen aus Datei
        Highscores.getInstance().restore();
        //Login Fenster anzeigen
        Clogin.show(primaryStage);
    }

    public void stop(){
        //Highscores speicherm
        Highscores.getInstance().store();
        //System beenden
        System.exit(1);

    }
}