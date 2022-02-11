import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continueAddingQuestions = false;
        int numQuestionsAdding = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<Question>();

        System.out.println("Welcome to Felix's Quiz Simulator.");
        System.out.println("Let's begin by adding some questions to the Quiz Bank. ");
        System.out.println("------------------------------------------------------ ");

        do{
            numQuestionsAdding++;
            System.out.println("Here, type the prompt for question number: " + String.valueOf(numQuestionsAdding) + "  [String]");
            String question = input.nextLine();
            System.out.println("Great. Now let's add some tricky options! How many options would you like to have for this question? [int]");
            int numOptions = input.nextInt();
            String[] options = new String[numOptions];
            System.out.println("Ok. Now let's add the options. ");

            int correctAnswerIndex = -1;
            boolean correctAnswerSpecified = false;
            for (int i = 0; i < numOptions; i++) {
                Scanner opInput = new Scanner(System.in);
                System.out.println("Option "+ String.valueOf(i+1)+  ": [String]");
                options[i] = opInput.nextLine();
                if(!correctAnswerSpecified){
                System.out.println("Is this the correct answer? [String:y/n] ");
                if(opInput.next().equals("y")){
                    correctAnswerIndex = i;
                    correctAnswerSpecified = true;
                }}
            }
            questions.add(new Question(question, options, correctAnswerIndex));

            System.out.println("Amazing! You just made a question! here's an overview.");
            System.out.println(questions.get(numQuestionsAdding-1));

            System.out.println("");
            System.out.println("Would you like to make another question?  [String y/n]");
            input.nextLine();
            continueAddingQuestions = input.nextLine().equals("y");

        }while(continueAddingQuestions);

        System.out.println("----------------------*****----------------------");
        System.out.println("The quiz begins now.");
        Quiz newQuiz = new Quiz(questions);
        newQuiz.beginQuiz();
    }
}
