package titlescreen;

import helper.Gamemode;

public class MTitlescreen {
    //In welcher Reihenfolge die Highscores angesehen werden können
    private final Gamemode order[] = {Gamemode.ADD, Gamemode.SUB, Gamemode.MUL, Gamemode.DIV, Gamemode.MIX};
    private int actHighscoreInt;
    private String username;


    public MTitlescreen(int actHighscoreInt, String username){
        setActHighscoreInt(actHighscoreInt);
        setUsername(username);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getActHighscoreInt() {
        return actHighscoreInt;
    }

    //Highscore ändern welcher Angzeigt werden soll
    public void setActHighscoreInt(int actHighscoreInt) {
        if(actHighscoreInt>4 ){
            actHighscoreInt=0;
        }else if(actHighscoreInt<0){
            actHighscoreInt=4;
            }

        this.actHighscoreInt = actHighscoreInt;
    }

    //Integer wert welcher durch die Buttons erhöht wird zu einem Gamemode umwandeln
    public Gamemode getActHighscoreMode() {
        return order[actHighscoreInt];
    }

}
