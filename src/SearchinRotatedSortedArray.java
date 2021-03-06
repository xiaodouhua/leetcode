/**
 * Created by dou lc on 2017/7/6 0006.
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int []nums={0,1,2,3,4,5,6,7};
        int target =5;
        SearchinRotatedSortedArray se=new SearchinRotatedSortedArray();
        System.out.println(se.search(nums,target));
    }
    public int search(int[] nums, int target) {
        int first = 0, last = nums.length;
        while (first != last) {
            final int mid = first + (last - first) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[first] <= nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[last-1])
                    first = mid + 1;
                else
                    last = mid;
            }
        }
        return -1;
    }
}
