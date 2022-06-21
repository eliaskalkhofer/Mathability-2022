package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import maingamescreen.CGamescreen;
import maingamescreen.MGamescreen;
import titlescreen.CTitlescreen;

public class Clogin {
    public TextField userinput;
    private Mlogin model;


    public static void show(Stage stage){
        try {

            //standard javafx
            FXMLLoader loader = new FXMLLoader(Clogin.class.getResource("Vlogin.fxml"));
            //Modell erstellen und Gamemode auswählen
            Parent parent = loader.load();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Mathability");
            stage.show();
            Clogin clogin = loader.getController();
            clogin.model = new Mlogin();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    public void login(ActionEvent actionEvent) {
        model.setUsername(userinput.getText());
        CTitlescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow(),model.getUsername());
    }
}
