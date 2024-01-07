import java.util.Arrays;

public class Task1 {
    //Using binary search
    public static void main(String[] args) {
        int[] nums = {4, 9, 10, 13, 17, 17,17, 19, 21};
        int[] nums2 = {2,3,4,5,6,7,8,8,8,9,10};
        int[] nums3 ={};
        int target=17;
        int target2=2;
        int target3=0;
        int[] res = solution(nums2,target2);
        System.out.println(Arrays.toString(res));

    }

    public static int[] solution(int[] nums, int target) {
        int[] res = new int[2];//only need to output first and last position;
        res[0] = findStartPosition(nums, target);
        res[1] = findEndPosition(nums, target);
        return res;
    }

    public static int findStartPosition(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid=start+(end-start)/2;
            if (nums[mid] == target) {//Check from mid, if nums[mid] equals to target keep tracking until find the first one.
                index = mid;
                end=mid-1;
            }
            else if (nums[mid] > target) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return index;
    }
    public static int findEndPosition(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (nums[mid] == target) {//Check from mid, if nums[mid]==target keep tracking to the last one.
                index = mid;
                start=mid+1;
            }
            else if (nums[mid]>target) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return index;
    }
}

