import java.util.Stack;
/**
 * Created by dou lc on 2017/7/5 0005.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s =")()())";
        LongestValidParentheses lvp =new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses(s));
    }

    /**
     *
     * @param s：
     * @return count:
     */
    public int longestValidParentheses(String s) {
        // the position of the last ')'
        int maxLen = 0, last = -1;
        // keep track of the positions of non-matching '('s
        Stack<Integer> lefts = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) =='(') {
                lefts.push(i);
            } else {
                if (lefts.empty()) {
                    // no matching left
                    last = i;
                } else {
                    // find a matching pair
                    lefts.pop();
                    if (lefts.empty()) {
                        maxLen = Math.max(maxLen, i-last);
                    } else {
                        maxLen = Math.max(maxLen, i-lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}
