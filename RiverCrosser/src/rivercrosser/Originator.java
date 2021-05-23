package rivercrosser;


public class Originator {

    private int score;

    public void setstate(int score) {
        this.score = score;

    }

    public ScoreSaving save() {
        return new ScoreSaving(score);

    }

    public void restore(ScoreSaving x) {
        score = x.getScore();
    }

    public static void main(String[] args) {

    }
}
