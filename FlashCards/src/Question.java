public class Question {
    private String question;
    private String[]options;
    private int correctAnswerIndex;

    public Question(){
        question = "";
    }
    public Question(String q, String[]ops, int ci){
        question = q;
        options = ops;
        correctAnswerIndex = ci;
    }
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
    public String getQuestion() {
        return question;
    }
    public String[] getOptions() {
        return options;
    }
    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }
    public void setOptions(String[] options) {
        this.options = options;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String toString() {
        String returnStatement = "";
        returnStatement = "Question: " + question;
        for (int i = 0; i < options.length; i++) {
            returnStatement += "\n" + String.valueOf(i + 1) + ") " + options[i];
            if (i == correctAnswerIndex) {
                returnStatement += " (correct answer)";
            }

        }
        return returnStatement;
    }
    public String toQuiz() {
        String returnStatement = "";
        returnStatement = "Question: " + question;
        for (int i = 0; i < options.length; i++) {
            returnStatement += "\n" + String.valueOf(i + 1) + ") " + options[i];
        }
        return returnStatement;
    }
}

