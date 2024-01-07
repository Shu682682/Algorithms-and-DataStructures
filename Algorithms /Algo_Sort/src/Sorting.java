public class Sorting {
    //merge Sort
    public static char[] mergeSortArray(char[] nums){
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    private static void mergeSort(char[]arr, int left, int right){//7654132
        if(left>=right) return;
        int mid=left+(right-left)/2;//set up mid index;
        mergeSort(arr, left, mid);//Using recursion to sort left side;//0-3
        mergeSort(arr, mid+1, right);//Using recursion to sort right side;
        merge(arr, left, mid, right);//Using merge function to merge sort part.
    }
    public static void merge(char[]nums, int left, int mid, int right){
        int i=left;
        int j=mid+1;
        int k=0;//index
        char[] temp=new char[nums.length];
        while(i<=mid && j<=right){
            if(nums[i]<nums[j]){
                temp[k]=nums[i];
                k++;
                i++;
            }
            else{
                temp[k]=nums[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            temp[k]=nums[i];
            k++;
            i++;
        }
        while(j<=right){
            temp[k]=nums[j];
            k++;
            j++;
        }
        for(int a=left; a<=right;a++){
            nums[a]=temp[a-left];
        }
    }


    //Quick Sort
    public static char[] quickSort(char[] nums){
        Sort(nums, 0,nums.length-1);
        return nums;
    }
    public static void Sort(char[] nums, int left, int right){
        if(left>=right) return;
        int start =left;
        int end=right;
        int mid=start+(end-start)/2;
        while(start<=end){//keep sorting until start >=end and then using recursiong to check left and right side.
            while(nums[start]<nums[mid]) {
                start++;
            }
            while(nums[end]>nums[mid]) {
                end--;
            }
            if(start<=end){
                char temp=nums[start];//swap
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
                end--;
            }
        }
        Sort(nums, left, end);
        Sort(nums, start, right);
    }
}
