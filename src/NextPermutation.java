
import java.util.Arrays;

/**
 * Created by dou on 2017/7/5 0005.
 */
public class NextPermutation {
    public static void main(String[] args) {
        int [] nums = {1,2};
        NextPermutation ne = new NextPermutation();
        ne.nextPermutation(nums);
        for (int i = 0; i <nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public void nextPermutation(int[] nums) {
        int num1=0,flag=0;
        for (int i = nums.length-1; i >=1 ; ) {
            //从后向前找，找到第一个非下降的数字的下标
            if(nums[i-1]>=nums[i]) i--;
            else {
                num1=i-1;
                flag=1;
                break;
            }
        }
        if(flag==0){
            Arrays.sort(nums);
        }else {
            int num2=0;
            //发现后面数字中大于Num1中最小的一个
            for (int i = nums.length-1; i > num1;) {
                if (nums[i]>nums[num1]){
                    num2=i;
                    break;
                }else {
                    i--;
                }
            }
            int tmp=nums[num1];
            nums[num1]=nums[num2];
            nums[num2]=tmp;
            Arrays.sort(nums,num1+1,nums.length);
        }
    }

}
