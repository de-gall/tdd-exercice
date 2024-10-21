import org.junit.Test;
import org.tddexercise.TextAnalyzer;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextAnalyzerTest {

    @Test
    public void shouldIgnoreBannedWords_WhenCalculatingFrequency() {
        // Given
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        List<String> bannedWords = Collections.singletonList("hit");

        // When
        String result = TextAnalyzer.findMostFrequentWord(paragraph, bannedWords);

        // Then
        assertEquals("ball", result);
    }

    @Test
    public void shouldBeCaseInsensitive_WhenComparingWords() {
        // Given
        String paragraph = "Hit hit HIT Ball ball";
        List<String> bannedWords = Collections.singletonList("hit");

        // When
        String result = TextAnalyzer.findMostFrequentWord(paragraph, bannedWords);

        // Then
        assertEquals("ball", result);
    }

    @Test
    public void shouldIgnorePunctuation_WhenCountingWords() {
        // Given
        String paragraph = "Bob hit a ball! The ball, flew far.";
        List<String> bannedWords = Collections.singletonList("hit");

        // When
        String result = TextAnalyzer.findMostFrequentWord(paragraph, bannedWords);

        // Then
        assertEquals("ball", result);
    }

    @Test
    public void shouldReturnUniqueMostFrequentWord_WhenItExists() {
        // Given
        String paragraph = "Apple apple apple Banana banana";
        List<String> bannedWords = Collections.singletonList("banana");

        // When
        String result = TextAnalyzer.findMostFrequentWord(paragraph, bannedWords);

        // Then
        assertEquals("apple", result);
    }

    @Test
    public void shouldHandleEmptyBannedWordsList() {
        // Given
        String paragraph = "Orange Orange Lemon Lemon Lemon";
        List<String> bannedWords = Collections.emptyList();

        // When
        String result = TextAnalyzer.findMostFrequentWord(paragraph, bannedWords);

        // Then
        assertEquals("lemon", result);
    }

    @Test
    public void shouldReturnCorrectWord_WhenThereIsAtLeastOneNonBannedWord() {
        // Given
        String paragraph = "Dog dog cat cat dog";
        List<String> bannedWords = Collections.singletonList("cat");

        // When
        String result = TextAnalyzer.findMostFrequentWord(paragraph, bannedWords);

        // Then
        assertEquals("dog", result);
    }
}
