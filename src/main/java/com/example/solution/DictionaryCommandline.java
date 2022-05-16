package com.example.solution;
import javafx.scene.control.ListView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DictionaryCommandline {
    public static int spaceword = 30;

    public List<String> showAllWordsWord(Dictionary dictionar) {
        List<String> line = new ArrayList<>();
        for (int i = 0; i < dictionar.list_word.size(); i++) {
            String english = dictionar.list_word.get(i).getWord_target() + " : " + dictionar.list_word.get(i).getWord_explain();
            line.add(english);
        }
        return line;
    }

    public List<String> suggestWord(Dictionary dictionary, String input) {
        List<String> line = new ArrayList<>();
        boolean isStart = false;
        for(int i = 0; i < dictionary.list_word.size(); i++) {
            String english = dictionary.get(i).getWord_target();
            if(english.length() >= input.length()) {
                if (dictionary.get(i).getWord_target().substring(0, input.length()).equals(input)) {
                    isStart = true;
                    line.add(dictionary.get(i).getWord_target());
                } else {
                    if (isStart) {
                        break;
                    }
                }
            }
        }
        return line;
    }

    public Word dictionarySearcher(Dictionary dictionary, String input) {
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).getWord_target().equals(input)) {
                return dictionary.get(i);
            }
        }
        return null;
       /*int n = dictionary.size();
       int l = 0;
       int r = n - 1;
       while(l < r) {
           int mid = (l+r)/2;
           if (dictionary.get(mid).getWord_target().compareTo(input) < 0) {
               l = mid + 1;
           }
           else if (dictionary.get(mid).getWord_target().compareTo(input) > 0) {
               r = mid - 1;
           }
           else {
               return dictionary.get(mid);
           }
       }
       return null;*/
    }


    public boolean wordInDictionary(Dictionary dictionary, String word) {
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).getWord_explain().equals(word) || dictionary.get(i).getWord_target().equals(word)) {
                return true;
            }
        }
        return false;
    }

    public boolean Delete(Dictionary dictionary, String delete) {
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).getWord_explain().equals(delete) || dictionary.get(i).getWord_target().equals(delete)) {
                dictionary.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean checkInDictionary(Dictionary dictionary, Word word) {
        if (word == null) return true;
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).getWord_target().equals(word.getWord_target()) && dictionary.get(i).getWord_explain().equals(word.getWord_explain()))
                return true;
        }
        return false;
    }

    public boolean Add(Dictionary dictionary, Word word) {
        if (word == null) return false;
        if (dictionary.size() == 0) {
            dictionary.add(word);
            return true;
        }
        if (word.getWord_target().compareTo(dictionary.get(0).getWord_target()) < 0) {
            dictionary.add(0, word);
            return true;
        }
        int n = dictionary.size();
        for (int i = 0; i < n - 1; i++) {
            int wordi = word.getWord_target().compareTo(dictionary.get(i).getWord_target());
            int iword = word.getWord_target().compareTo(dictionary.get(i+1).getWord_target());
            if (wordi > 0 && iword < 0) {
                dictionary.add(i + 1, word);
                return true;
            }
            else if (wordi == 0 || iword == 0) {
                break;
            }
        }
        if (word.getWord_target().compareTo(dictionary.get(n - 1).getWord_target()) > 0) {
            dictionary.add(word);
            return true;
        }
        return false;
    }

}