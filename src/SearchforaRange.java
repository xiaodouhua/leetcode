/**
 * Created by dou lc on 2017/7/6 0006.
 */
public class SearchforaRange {
    public static void main(String[] args) {
        int [] nums={5, 7, 7, 8, 8, 10};
        int target =8;
        SearchforaRange se=new SearchforaRange();
        int [] re =se.searchRange(nums,target);
        System.out.println(""+re[0]+'\t'+re[1]);
    }


    public int[] searchRange(int[] nums, int target) {
        int lower = lower_bound(nums, 0, nums.length, target);
        int upper = upper_bound(nums, 0, nums.length, target);
        if (lower == nums.length || nums[lower] != target)
            return new int[]{-1, -1};
        else
            return new int[]{lower, upper-1};
    }
    int lower_bound (int[] A, int first, int last, int target) {
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (target > A[mid]) first = ++mid;
            else last = mid;
        }
        return first;
    }
    int upper_bound (int[] A, int first, int last, int target) {
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (target >= A[mid]) first = ++mid; // 与 lower_bound 仅此不同
            else last = mid;
        }
        return first;
    }
}
