package maingamescreen;

import helper.Gamemode;
import helper.Highscores;
import helper.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scorescreen.CScore;

public class CGamescreen {

    private MGamescreen model;
    private Gamemode zwisch;
    private Stage stage;

    public Button ans1;
    public Button ans2;
    public Button ans3;
    public Button ans4;


    public Label lbrechnung;
    public ProgressBar pbtimeleft;
    public Label lbscore;


    //start
    public static void show(Stage stage, Gamemode mode) {
        try {

            //standard javafx
            FXMLLoader loader = new FXMLLoader(CGamescreen.class.getResource("VGamescreen.fxml"));
            //Modell erstellen und Gamemode auswählen
            Parent parent = loader.load();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Mathability");
            stage.show();


            CGamescreen cGamescreen = loader.getController();
            cGamescreen.model = new MGamescreen(mode);
            cGamescreen.stage = stage;
            cGamescreen.last();
            cGamescreen.showRechnung();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }//show


    @FXML
    public void initialize(){

    }

   private void last(){
       pbtimeleft.progressProperty().bind(model.timeleftProperty());
   }

    private void showRechnung(){
        model.getnewRechung();//neue Rechnung erzeugen
        lbscore.setText( model.getScore()+" pt");//Score aktuellisieren

        lbrechnung.setText(model.getGameInfos()[0]); //Rechnung
        //4 Antwortmöglichkeiten
        ans1.setText(model.getGameInfos()[1]);
        ans2.setText(model.getGameInfos()[2]);
        ans3.setText(model.getGameInfos()[3]);
        ans4.setText(model.getGameInfos()[4]);

        model.resetTimer();
    }//showrechnung


    //überprüfen ob das Ergebnis richtig ist
    private void checkans(String answer){
        System.out.print("Gewählte Antwort:" +answer);

        //Überprüfung ob die Richtige Option gewäht wurde
        if(Integer.parseInt(answer) ==model.getRightans()){
            //Richtig

            System.out.println("  Und richtig gelöst");
            model.setScore(model.getScore()+1);

        }else {
           //versuch stoppen

            System.out.println(" Und falsch gelöst ");
            model.stopTimer();
            end("Falsche Antwort");

        }

    }//checkans


    //Beim Knopfdruck
    public void btoptionpressed(ActionEvent actionEvent) {
        model.resetTimer();
        String choosenans =((Button)actionEvent.getSource()).getText();

        checkans(choosenans);

        //Nächste Rechnung
        showRechnung();
    }//btoptionpressed


    private void end(String msg){
        Score actscore = new Score(model.getScore(), model.getId(), model.getCurrent());
        ((Highscores)Highscores.getInstance()).addScore(actscore);

        CScore.show(stage,actscore);
    }
}
