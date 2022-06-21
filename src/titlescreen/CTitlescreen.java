package titlescreen;

import helper.Gamemode;
import helper.Highscores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import maingamescreen.CGamescreen;

import java.io.IOException;


public class CTitlescreen {

    public Button btleft;
    public ListView listview;
    public Button btright;
    public Label lbmode;


    private MTitlescreen model;
    private CTitlescreen cTitlescreen;

    public static void show(Stage stage) {
        try {
            //standard javafx
        FXMLLoader loader = new FXMLLoader(CTitlescreen.class.getResource("VTitlescreen.fxml"));
        Parent parent =loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Mathability");
        stage.show();
        CTitlescreen cTitlescreen = loader.getController();
        cTitlescreen.model = new MTitlescreen(0);
        cTitlescreen.showlist();
cTitlescreen.changeLabel();

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

    private void showlist(){
        listview.setItems(FXCollections.observableList(Highscores.getInstance().getList(model.getActHighscoreMode())));
    }

    private void changeLabel(){
        lbmode.setText(model.getActHighscoreMode()+"");
    }



    public void nextOnAction(ActionEvent actionEvent) {
        //nächste Highscoresliste anzeigen
        if(((Button)actionEvent.getSource())==btleft){
            model.setActHighscoreInt(model.getActHighscoreInt()-1);

        }else {
            model.setActHighscoreInt(model.getActHighscoreInt()+1);
        }
showlist();
        changeLabel();
    }
}
