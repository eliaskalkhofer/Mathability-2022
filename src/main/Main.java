package main;

import javafx.application.Application;
import javafx.stage.Stage;
import maingamescreen.CGamescreen;

public class Main extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CGamescreen.show(primaryStage);
    }ä
}