/**
 * Created by dou lc on 2017/6/27 0027.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
            int count=0;
            int len =nums.length;
            //int []flag=new int[len];
            for (int i=1;i<len;i++) {
                if (nums[i - 1] == nums[i]) {
                    count++;
                }
                nums[i-count]=nums[i];
            }
            return len-count;
    }
    public int removeElement(int[] nums, int val) {
        int count=0;
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==val){
                count++;
            }else{
                nums[i-count]=nums[i];
            }
        }
        return len-count;
    }
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    /***
     * 利用二进制的思想。ex.29/4=(16+8+4)/4=(4*4+4*2+4*1)/4=4
     * @param dividend
     * @param divisor
     * @return result
     */
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        int i,total = 0;
        //判断正负号
        boolean sign = ((dividend < 0) ^ (divisor < 0));
        //这里必须要long,因为如果最小值取绝对值会溢出
        long did = Math.abs((long)dividend);
        long dis = Math.abs((long)divisor);
        while(did >= dis)
        {
            long mul_dis = dis;
            i = 0;
            //每次左移乘2，记录下来，直到不能减
            while(did >= (mul_dis<<1))
            {
                i++;
                mul_dis <<= 1;
            }
            did -= mul_dis;
            total += 1<<i;
        }
        //根据符号返回
        return sign ? -total:total;
    }

}
