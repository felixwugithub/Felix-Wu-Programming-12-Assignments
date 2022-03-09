package com.felixwu.reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int uniqueWordCount = 0;

        File file = new File("illiad.txt");
        HashSet<String> wordSet = new HashSet();
        List<String> textSet = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split("\\W+");
                for (String word: words
                     ) {
                    wordSet.add(word.toLowerCase());
                    textSet.add(word.toLowerCase());
                }
            }

            int progress = 0;
            int total = wordSet.size();
            for (String word: wordSet
                 ) {
                progress++;

                System.out.println("Checking " + progress + " th word out of " + total + " different words.");
               int occurrences = Collections.frequency(textSet, word);
                if (occurrences == 1){

                    uniqueWordCount++;
                }


            }

            System.out.println(uniqueWordCount);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
