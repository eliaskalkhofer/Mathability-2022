package maingamescreen;

import helper.Gamemode;

import java.util.Timer;

public class MGamescreen {
    private Gamemode current;   //Welchen Gamemode man spielen möchte
    private int id;             //Welche Id dieses Spiel hat
    private int score;          //Welchen Score dieses Spiel erreicht hat
    private Timer gametimer;    //Gametimer während des Spieles
    private String[] gameInfos;

    public MGamescreen(Gamemode mode) {
        setCurrent(mode);
    }

    public Gamemode getCurrent() {
        return current;
    }

    public void setCurrent(Gamemode current) {
        this.current = current;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timer getGametimer() {
        return gametimer;
    }

    public void setGametimer(Timer gametimer) {
        this.gametimer = gametimer;
    }

    public String[] getGameInfos() {
        return gameInfos;
    }

    //Aktuell nur Addition möglich
    public void getnewRechung() {


        switch (current) {
            case ADD:
                gameInfos = getAdd();
                break;
            default:
                gameInfos = null;
                break;
        }
    }

    //Muss erst implementiert werden
    private String[] getAdd() {
        String paket[] = new String[5];
        paket[0] = "1+1";
        paket[1] = "3";
        paket[2] = "5";
        paket[3] = "2";
        paket[4] = "99";
        return paket;
    }

    private String[] getSub() {
        String paket[] = new String[5];
        paket[0] = "1+1";
        paket[1] = "3";
        paket[2] = "5";
        paket[3] = "2";
        paket[4] = "99";
        return paket;
    }

    private String[] getMul() {
        String paket[] = new String[5];
        paket[0] = "1+1";
        paket[1] = "3";
        paket[2] = "5";
        paket[3] = "2";
        paket[4] = "99";
        return paket;
    }

    private String[] getDiv() {
        String paket[] = new String[5];
        paket[0] = "1+1";
        paket[1] = "3";
        paket[2] = "5";
        paket[3] = "2";
        paket[4] = "99";
        return paket;
    }
}