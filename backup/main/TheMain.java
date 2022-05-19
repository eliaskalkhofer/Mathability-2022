package main;

import controllerview.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class TheMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller.show(primaryStage);
    }
}
