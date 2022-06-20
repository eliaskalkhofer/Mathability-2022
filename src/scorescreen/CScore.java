package scorescreen;

import helper.Gamemode;
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
    MScore model;

    public static void show(Stage stage, int score, String id){
        try {

            //standard javafx
            FXMLLoader loader = new FXMLLoader(CScore.class.getResource("VScore.fxml"));
            //Modell erstellen und Gamemode auswählen
            Parent parent = loader.load();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Mathability");
            stage.show();


            CScore cGamescreen = loader.getController();
            cGamescreen.model = new MScore(id,score);
            cGamescreen.loadmodel();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        


    }


    public void loadmodel(){
        txName.setText("Benutzer: "+model.getName());
        txScore.setText("Score: "+model.getScore()+" Punkte");
        
    }

    public void exitOnAction(ActionEvent actionEvent) {

        CTitlescreen.show((Stage) ((Node)actionEvent.getSource()).getScene().getWindow());
    }
}
