/**
 * Created by dou lc on 2017/7/7 0007.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6},2));
    }
    public int searchInsert(int[] nums, int target) {
        return lower_bound(nums, 0, nums.length, target);
    }
    int lower_bound (int[] A, int first, int last, int target) {
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (target > A[mid]) first = ++mid;
            else last = mid;
        }
        return first;
    }
}
