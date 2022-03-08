package com.felixwu.reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int uniqueWordCount = 0;

        File file = new File("illiad.txt");
        HashSet<String> wordSet = new HashSet();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split("\\W+");
                for (String word: words
                     ) {
                    wordSet.add(word.toLowerCase());
                }
            }
            System.out.println("There are " + wordSet.size() + " different words in this book.");

            int progress = 0;
            int total = wordSet.size();
            for (String differentWord: wordSet
                 ) {
                progress++;
                System.out.println("Checking word " + progress + " of " + total + " : " + differentWord);
                int occurence = 0;
                Scanner counter = new Scanner(file);
                while(counter.hasNextLine()){
                    String line = counter.nextLine();
                    String[] words = line.split("\\W+");
                    for (String word: words
                    ) {
                        if (word.toLowerCase().equals(differentWord)){
                            occurence++;
                        }
                        if(occurence > 1){
                            break;
                        }
                    }
                    if (occurence > 1){
                        uniqueWordCount++;
                    }
                }

            }

            System.out.println("There are " +
                    uniqueWordCount
                    + " unique words"
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
