import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    //Test Code
    public static void main(String[] args) {
        String[] strs = {"tab","bucket", "bat", "mango", "tango", "ogtan", "tar"};
        String[] strs2 = {"hamburger", "ham", "dog", "god", "can", "nac"};
        List<List<String>> res = groupAnagram(strs);
        System.out.println(Arrays.toString(res.toArray()));

    }
    //Task1 groupAnagram function
    public static List<List<String>> groupAnagram(String[] strs){
        if (strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();//Build a map to keep anagram words.
        for (String i : strs) {
            char[] chars = i.toCharArray();
            Sorting.mergeSortArray(chars);//use MergeSort function
           // Sorting.quickSort(chars);//use quickSort function
            String sortedStr = String.valueOf(chars);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(i);
        }
        return new ArrayList<>(map.values());
    }
}


