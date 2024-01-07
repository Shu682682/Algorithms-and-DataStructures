public class Task2 {
    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix2={{1,3,5,9},{10,11,16,20},{21,30,34,60}};
        int target=20;
        int target2=80;
        boolean res=solution(matrix, target2);
        System.out.println(res);

    }
    public static boolean solution(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start <= end) {
            int mid =start+(end-start)/2;//prevent integer overflow
            int midnumber=matrix[mid/col][mid%col];//turn array position into matrix position
            if (midnumber == target) {
                return true;
            }
            if (midnumber < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}


