package helper;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class Highscores implements Serializable {
    //Filepath
    private static final String FILEPATH = "scores.ser";

    //Instanzieren
    private static Highscores highscores;

    //Highscorelisten
    private List<Score> addHS;
    private List<Score> subHS;
    private List<Score> mulHS;
    private List<Score> divHS;
    private List<Score> mixHS;


    //klassich getInstance
    public static Highscores getInstance(){
        if(highscores ==null){
            highscores = new Highscores();
        }
        return highscores;
    }

    private Highscores(){
        //Versuche aus der Datei zu laden
        //Ansonst neue Highscores anlegen
        try{
            restore();
        }catch (Exception ex){
            //Listen werden neu erstellt
            addHS = new LinkedList();
            subHS = new LinkedList();
            divHS = new LinkedList();
            mulHS = new LinkedList();
            mixHS = new LinkedList();
        }



    }

    //eine Score in die Liste aufnehmen
    public void addScore(Score score){
        switch (score.getType()){
            case ADD:
                addHS.add(score);
                break;
            case MIX:
                mixHS.add(score);
                break;

            case SUB:
                subHS.add(score);
                break;
            case MUL:
                mulHS.add(score);
                break;
            case DIV:
                divHS.add(score);
                break;

        }
    }


    //aus Datei laden
    public void restore() throws IOException, ClassNotFoundException {
        FileInputStream filein = new FileInputStream(FILEPATH);
        ObjectInputStream objectIn = new ObjectInputStream(filein);
        highscores =(Highscores) objectIn.readObject();
        objectIn.close();
        System.out.println("Erfolgreich wiederhergestellt");

    }
    //in Datei laden
   public void store(){
        try {

            FileOutputStream fileOut = new FileOutputStream(FILEPATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(highscores);
            objectOut.close();
            System.out.println("Highscores erfolgreich gespeichert!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //gewünschte Liste bekommen
    public List<Score> getList(Gamemode typ){
        switch (typ){
            case ADD:
                return addHS;

            case MIX:
                return mixHS;


            case SUB:
               return subHS;

            case MUL:
                return mulHS;

            case DIV:
                return divHS;

        }
        return null;
    }

}
