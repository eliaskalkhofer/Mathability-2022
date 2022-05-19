package maingamescreen;

import helper.Gamemode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CGamescreen {

    private MGamescreen model;

    @FXML
    public Button ans1;
    @FXML
    public Button ans2;
    @FXML
    public Button ans3;
    @FXML
    public Button ans4;

    @FXML
    public TextField tfrechnung;
    @FXML
    public ProgressBar pbtimeleft;
    @FXML
    public TextField tfscore;


    public static void show(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader(CGamescreen.class.getResource("VGamescreen.fxml"));
            Parent parent = loader.load();


            Scene scene = new Scene(parent, 400, 500);
            stage.setScene(scene);
            stage.setTitle("Mathability");
            stage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    @FXML
    public void initialize(){
        model = new MGamescreen(Gamemode.ADD);
        //Rechnung erzeugen und dem Bemutzer anzeigen
        showRechnung();
    }

    private void showRechnung(){
        model.getnewRechung();

        tfrechnung.setText(model.getGameInfos()[0]);
        ans1.setText(model.getGameInfos()[1]);
        ans2.setText(model.getGameInfos()[2]);
        ans3.setText(model.getGameInfos()[3]);
        ans4.setText(model.getGameInfos()[4]);

    }

    private void checkans(String answer){
        System.out.println("Gewählte Antwort:" +answer);
        //Überprüfung ob die Richtige Option gewäht wurde
    }

    public void btoptionpressed(ActionEvent actionEvent) {
        String choosenans =((Button)actionEvent.getSource()).getId();

        checkans(choosenans);
    }
}
