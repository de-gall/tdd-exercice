import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.tddexercise.TextAnalyzer;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class TextAnalyzerTest {
    @DataPoints
    public static String[] bannedWords = {
            "hit", "Hit", "HIt", "HIT"
    };

    @Theory
    public void testFindMostFrequentWord(String banned) {
        // Given
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";

        // When
        List<String> bannedList = Collections.singletonList(banned);
        String result = TextAnalyzer.findMostFrequentWord(paragraph, bannedList);

        // Then
        assertEquals("ball", result);
    }
}