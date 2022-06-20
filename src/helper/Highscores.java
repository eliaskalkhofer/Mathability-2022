package helper;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Highscores implements Serializable {

    private static Highscores highscores;
    private static final String FILEPATH = "helper//obj";

    private List<Integer> addHS;
    private List<Integer> subHS;
    private List<Integer> mulHS;
    private List<Integer> divHS;
    private List<Integer> mixHS;


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

    private void addScore(Gamemode typ, int score, String name){
        switch (typ){
            case ADD:
                addHS.add(score);



        }
    }


    private void restore() throws IOException, ClassNotFoundException {
        FileInputStream filein = new FileInputStream(FILEPATH);
        ObjectInputStream objectIn = new ObjectInputStream(filein);
        highscores =(Highscores) objectIn.readObject();
        objectIn.close();
        System.out.println("Erfolgreich wiederhergestellt");

    }
    private void store(){
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
}
