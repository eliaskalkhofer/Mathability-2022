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
import login.Clogin;
import maingamescreen.CGamescreen;

import java.io.IOException;


public class CTitlescreen {

    public Button btleft;
    public ListView listview;
    public Button btright;
    public Label lbmode;
    public Label lbuser;


    private MTitlescreen model;
    private CTitlescreen cTitlescreen;

    public static void show(Stage stage, String username) {
        try {
            //standard javafx
        FXMLLoader loader = new FXMLLoader(CTitlescreen.class.getResource("VTitlescreen.fxml"));
        Parent parent =loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Mathability");
        stage.show();

        //model wird erstellt
        CTitlescreen cTitlescreen = loader.getController();
        cTitlescreen.model = new MTitlescreen(0, username);
        //Liste wird mit Werten befüllt
        cTitlescreen.showlist();

        //Überschrift wird geändert
        cTitlescreen.changeLabel();

        //welcher User aktuelle angemeldet ist
        cTitlescreen.showlbuser();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    //Auswählen des Gamemodes
    public void btGamemode(ActionEvent actionEvent) {
      String choosenGamemode = ((Button)actionEvent.getSource()).getId();
      Gamemode zwisch = null;
      //welcher Gamemode verwendet wird
        switch (choosenGamemode){
            case "ADD":

                zwisch = Gamemode.ADD;
                break;
            case "SUB":

                zwisch = Gamemode.SUB;
                break;
            case "MUL":

                zwisch = Gamemode.MUL;
                break;
            case "DIV":

                zwisch = Gamemode.DIV;
                break;
            case "MIX":

               zwisch = Gamemode.MIX;
                break;
        }
        //Übertragen werden die aktuelle Stage, der aktuelle Spielmodus und der Benutzername
        CGamescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow(), zwisch, model.getUsername());

    }

    private void showlist(){
        //Liste wird von Highscores geladen und in die Listview gestellt
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
        //nächste Liste und nächste Überschrift wird angezeigt
        showlist();
        changeLabel();
    }


    private void showlbuser(){
        lbuser.setText("angemeldet als: "+model.getUsername());
    }

    //Abmeldung und zurück zum Login
    public void btlogout(ActionEvent actionEvent) {
        Clogin.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow());
    }
}
