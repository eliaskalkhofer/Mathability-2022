package scorescreen;

import helper.Gamemode;
import helper.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import maingamescreen.CGamescreen;
import maingamescreen.MGamescreen;
import titlescreen.CTitlescreen;

public class CScore {
    public Text txName;
    public Text txScore;
    public Text txmsg;
    MScore model;

    public static void show(Stage stage, Score score, String msg){
        try {

            //standard javafx
            FXMLLoader loader = new FXMLLoader(CScore.class.getResource("VScore.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Mathability");
            stage.show();


            //model erstellen
            CScore cGamescreen = loader.getController();
            cGamescreen.model = new MScore(score, msg);
            cGamescreen.loadmodel();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    //Modell in Ansicht laden
    public void loadmodel(){
        txName.setText("Benutzer: "+model.getScore().getName());
        txScore.setText("Score: "+model.getScore().getAmount()+" Punkte");
        txmsg.setText(model.getMsg());

        
    }

    //Score screen verlassen
    public void exitOnAction(ActionEvent actionEvent) {
//Weiterleitung an Titel screen
        CTitlescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow(), model.getScore().getName());
    }
}
