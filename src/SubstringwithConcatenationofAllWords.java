import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dou lc on 2017/7/1
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *For example, given:
 *s: "barfoothefoobarman"
 *words: ["foo", "bar"]
 *You should return the indices: [0,9].(order does not matter).
 * 题目比较费劲，返回这样的所有下标：以此下标开始，可以包含所有的words字符串，中间字符串之间是要连续的
 */
public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args){
       String s="barfoothefoobarman";
       String[] words={"foo", "bar"};
       SubstringwithConcatenationofAllWords substringwithConcatenationofAllWords=new SubstringwithConcatenationofAllWords();
       List<Integer> list=substringwithConcatenationofAllWords.findSubstring(s,words);
       for(Integer i:list){
           System.out.println(i);
       }

    }



    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>list=new ArrayList<Integer>();
        for(String str:words){
            Integer index=s.indexOf(str);
            list.add(index);
        }
        return  list;
    }
}
