package com.example.parsingfiles;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Class responsible for calculating the word frequencies of the document Alice in Wonderland*/
public class BookParser {
    
    public Map<String, Integer> wordFrequencyDir(File dir) throws IOException {
        Map<String, Integer> frequencies = new TreeMap<>();

        File[] filesInDir = dir.listFiles();
        int numFiles = filesInDir.length;

        // iterate over each file in the dir and count their words
        for (int i = 0; i<numFiles; i++){
            Map<String, Integer> wordMap = countWordFile(filesInDir[i]);

        // merge the file wordMap into the global frequencies
            Set<String> keys = wordMap.keySet();
            Iterator<String> keyIterator = keys.iterator();
            while (keyIterator.hasNext()){
                String word  = keyIterator.next();
                int count = wordMap.get(word);

                if(frequencies.containsKey(word)){
                    // increment
                    int oldCount = frequencies.get(word);
                    frequencies.put(word, count + oldCount);
                }
                else{
                    frequencies.put(word, count);
                }
            }

        }
        
        return frequencies;
    }

    private Map<String, Integer> countWordFile(File file) throws IOException {
        Map<String, Integer> wordMap = new TreeMap<>();
        if(file.exists()){
        // load all the data and process it into words
            Scanner scanner  = new Scanner(file);
            while(scanner.hasNext()){
                // ignore the casing for words
                String word = (scanner.next()).toLowerCase();
                if (isWord(word)){
                    // add the word if not exists yet
                    if(!wordMap.containsKey(word)){
                        wordMap.put(word, 1);
                    }
                    // increment the count if exists
                    else{
                        int oldCount = wordMap.get(word);
                        wordMap.put(word, oldCount+1);
                    }
                }
            }
        }
        return wordMap;
    }

    private Boolean isWord(String word){
        if (word == null){
            return false;
        }

        String pattern = "^[a-zA-Z]*$";
        if(word.matches(pattern)){
            return true;
        }

        return false;

    }
}
