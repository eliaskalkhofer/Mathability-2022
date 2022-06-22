package scorescreen;

import helper.Gamemode;
import helper.Score;

public class MScore {
    private Score score;
    private String msg;
    public MScore(Score score, String msg){
        setScore(score);
        setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
