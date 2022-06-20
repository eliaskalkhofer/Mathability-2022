package titlescreen;

import helper.Gamemode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import maingamescreen.CGamescreen;

import java.io.IOException;


public class CTitlescreen {

    public static void show(Stage stage) throws IOException {
        try {
            //standard javafx
        FXMLLoader loader = new FXMLLoader(CTitlescreen.class.getResource("VTitlescreen.fxml"));
        Parent parent =loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Mathability");
        stage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

//Kurzer Prototyp keineswegs fertig

    //Auswählen des Gamemodes
    public void btGamemode(ActionEvent actionEvent) {
      String choosenGamemode = ((Button)actionEvent.getSource()).getId();
        switch (choosenGamemode){
            case "ADD":
                //Langer Code um die aktuelle Stage weiterzugeben
                CGamescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow(), Gamemode.ADD);
                break;
            case "SUB":
                //Langer Code um die aktuelle Stage weiterzugeben
                CGamescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow(), Gamemode.SUB);
                break;
            case "MUL":
                //Langer Code um die aktuelle Stage weiterzugeben
                CGamescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow(), Gamemode.MUL);
                break;
            case "DIV":
                //Langer Code um die aktuelle Stage weiterzugeben
                CGamescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow(), Gamemode.DIV);
                break;
            case "MIX":
                //Langer Code um die aktuelle Stage weiterzugeben
                CGamescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow(), Gamemode.MIX);
                break;
        }
    }


}
