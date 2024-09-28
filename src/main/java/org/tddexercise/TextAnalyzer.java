package org.tddexercise;

import java.util.*;

public class TextAnalyzer {

    public static String findMostFrequentWord(String paragraph, List<String> bannedWords) {
        String normalized = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        List<String> bannedWordsTiny = bannedWords.stream().map(String::toLowerCase).toList();

        String[] words = normalized.split("\\s+");

        Set<String> bannedSet = new HashSet<>(bannedWordsTiny);
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        String mostFrequentWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequentWord;
    }
}
