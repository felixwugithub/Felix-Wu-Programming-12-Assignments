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

            for (String word: wordSet
                 ) {
               int occurrences = Collections.frequency(textSet, word);
                if (occurrences == 1){
                    uniqueWordCount++;
                    System.out.println("FOUND UNIQUE WORD: " + word);
                }
            }

            System.out.println("There are ");
            System.out.println(uniqueWordCount);
            System.out.println("Unique words");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
