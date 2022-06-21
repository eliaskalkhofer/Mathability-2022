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
        CTitlescreen cTitlescreen = loader.getController();
        cTitlescreen.model = new MTitlescreen(0, username);
        cTitlescreen.showlist();
cTitlescreen.changeLabel();
cTitlescreen.showlbuser();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    //Auswählen des Gamemodes
    public void btGamemode(ActionEvent actionEvent) {
      String choosenGamemode = ((Button)actionEvent.getSource()).getId();
      Gamemode zwisch = null;
        switch (choosenGamemode){
            case "ADD":
                //Langer Code um die aktuelle Stage weiterzugeben
                zwisch = Gamemode.ADD;
                break;
            case "SUB":
                //Langer Code um die aktuelle Stage weiterzugeben
                zwisch = Gamemode.SUB;
                break;
            case "MUL":
                //Langer Code um die aktuelle Stage weiterzugeben
                zwisch = Gamemode.MUL;
                break;
            case "DIV":
                //Langer Code um die aktuelle Stage weiterzugeben
                zwisch = Gamemode.DIV;
                break;
            case "MIX":
                //Langer Code um die aktuelle Stage weiterzugeben
               zwisch = Gamemode.MIX;
                break;
        }
        CGamescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow(), zwisch, model.getUsername());

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
    private void showlbuser(){
        lbuser.setText("angemeldet als: "+model.getUsername());
    }

    public void btlogout(ActionEvent actionEvent) {
        Clogin.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow());
    }
}
