package com.felixwu.reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //an integer representing the amount of words THAT ONLY APPEAR ONCE (I seemed to have misunderstood the meaning of "Unique")
        int uniqueWordCount = 0;

        File file = new File("illiad.txt");

        //a set representing every word that appears (HOME, home, hOmE, home! , hoME? are all the same words, so they will only be added once.)
        HashSet<String> wordSet = new HashSet();

        List<String> textSet = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){

                String line = scanner.nextLine();
                //regex seperates each line into an array of Strings based on spaces and punctuation.
                String[] words = line.split("\\W+");

                for (String word: words
                     ) {
                    wordSet.add(word.toLowerCase());
                    textSet.add(word.toLowerCase());
                }
            }


            for (String word: wordSet
                 ) {
               int occurrences = Collections.frequency(textSet, word);
                if (occurrences == 1){
                    uniqueWordCount++;
                    System.out.println("FOUND UNIQUE WORD: " + word);
                }
            }

            System.out.println("There are ");
            System.out.print(wordSet.size());
            System.out.println(" different words, out of which");
            System.out.print(uniqueWordCount);
            System.out.println(" words only appear once. ");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
