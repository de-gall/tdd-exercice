package org.tddexercise;

import java.util.*;
import java.util.stream.Collectors;

public class TextAnalyzer {

    public static String findMostFrequentWord(String paragraph, List<String> bannedWords) {
        String normalized = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        Set<String> bannedSet = bannedWords.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        Map<String, Integer> wordCount = Arrays.stream(normalized.split("\\s+"))
                .filter(word -> !bannedSet.contains(word))
                .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
