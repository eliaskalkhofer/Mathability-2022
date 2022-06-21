package titlescreen;

import helper.Gamemode;

public class MTitlescreen {
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

    public void setActHighscoreInt(int actHighscoreInt) {
        if(actHighscoreInt>4 ){
            actHighscoreInt=0;
        }else if(actHighscoreInt<0){
            actHighscoreInt=4;
            }

        this.actHighscoreInt = actHighscoreInt;
    }

    public Gamemode getActHighscoreMode() {
        return order[actHighscoreInt];
    }

    public void incremntacthighscoreint(){
        actHighscoreInt++;
    }
}
