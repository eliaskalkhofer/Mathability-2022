package scorescreen;

public class MScore {
    private String name;
    private int score;

    public MScore(String name, int score){
        setName(name);
        setScore(score);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
