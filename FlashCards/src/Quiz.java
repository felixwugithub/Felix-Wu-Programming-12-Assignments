
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz(ArrayList<Question> questions){
        this.questions = questions;
    }

    public void beginQuiz(){

        ArrayList<Question> questionsShuffled = shuffleList(questions);
        int points = 0;
        Scanner challenger = new Scanner(System.in);
        for (int i = 0; i < questionsShuffled.size(); i++) {
            System.out.println("Question " + String.valueOf(i+1) + ": ");
            System.out.println(questionsShuffled.get(i).toQuiz());
            System.out.println("enter the number of your choice. [int]");
            if(challenger.nextInt()-1 == questionsShuffled.get(i).getCorrectAnswerIndex()){
                System.out.println("Nice!");
                points++;
            }else{
                String correctAnswer = questionsShuffled.get(i).getOptions()[questionsShuffled.get(i).getCorrectAnswerIndex()];
                System.out.println("Wrong!");
                System.out.println("The correct answer is " + correctAnswer);
            }
        }
        System.out.println("you've completed the quiz. You got " + String.valueOf(points) + " out of " + String.valueOf(questionsShuffled.size()));
        System.out.println("Good night.");
    }

    //simple shuffler method that I wrote, it seems to work.
    private ArrayList<Question> shuffleList(ArrayList<Question> arrayIn){

        ArrayList<Question> shuffledList = arrayIn;
        for (int i = 0; i < arrayIn.size(); i++) {
            int index = (int) (Math.random()*arrayIn.size());
            Question temp = shuffledList.get(index);
            shuffledList.set(index, arrayIn.get(i));
            shuffledList.set(i,temp);
        }
        return shuffledList;
        //Testing edits
    }



}
