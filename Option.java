public class Option {
    int optionId;
    String optionText;
    boolean correctOption;

    public Option(int optionId, String optionText, boolean correctOption) {
        this.optionId = optionId;
        this.optionText = optionText;
        this.correctOption = correctOption;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public boolean isCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(boolean correctOption) {
        this.correctOption = correctOption;
    }
}
