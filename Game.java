public class Game {
    String story;
    Option op1;
    Option op2;

    public Game(String story, Option op1, Option op2) {
        this.story = story;
        this.op1 = op1;
        this.op2 = op2;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Option getOp1() {
        return op1;
    }

    public void setOp1(Option op1) {
        this.op1 = op1;
    }

    public Option getOp2() {
        return op2;
    }

    public void setOp2(Option op2) {
        this.op2 = op2;
    }
}
