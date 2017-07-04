import com.sun.org.apache.xml.internal.security.keys.storage.implementations.SingleCertificateResolver;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
/**
 * Created by dou lc on 2017/7/1
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *For example, given:
 *s: "barfoothefoobarman"
 *words: ["foo", "bar"]
 *You should return the indices: [0,9].(order does not matter).
 * 题目比较费劲，返回这样的所有下标：以此下标开始，可以包含所有的words字符串，中间字符串之间是要连续的
 */
public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        SubstringwithConcatenationofAllWords substringwithConcatenationofAllWords = new SubstringwithConcatenationofAllWords();
        List<Integer> list = substringwithConcatenationofAllWords.findSubstring(s, words);
        for (Integer i : list) {
            System.out.println(i);
        }

    }

    public List<Integer> findSubstring(String s, String[] words) {
        final int wordLength = words[0].length();
        final int catLength = wordLength * words.length;
        List<Integer> result = new ArrayList<>();
        if (s.length() < catLength) return result;
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        for (int i = 0; i <= s.length() - catLength; ++i) {
            HashMap<String, Integer> unused = new HashMap<>(wordCount);
            for (int j = i; j < i + catLength; j += wordLength) {
                final String key = s.substring(j, j + wordLength);

                final int pos = unused.getOrDefault(key, -1);
                if (pos == -1 || pos == 0) break;
                unused.put(key, pos - 1);
                if (pos - 1 == 0) unused.remove(key);
            }
            if (unused.size() == 0) result.add(i);
        }
        return result;
    }
}
