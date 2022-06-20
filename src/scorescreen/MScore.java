package scorescreen;

import helper.Gamemode;
import helper.Score;

public class MScore {
    private Score score;
    public MScore(Score score){
        setScore(score);
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
